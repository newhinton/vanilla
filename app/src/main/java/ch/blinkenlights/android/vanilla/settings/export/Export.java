package ch.blinkenlights.android.vanilla.settings.export;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import ch.blinkenlights.android.medialibrary.MediaLibrary;
import ch.blinkenlights.android.vanilla.R;
import ch.blinkenlights.android.vanilla.SharedPrefHelper;

public class Export {

	private static final String TAG = "Exporter";
	public static void exportSettings(Activity activity){
		writeXML(activity);
	}

	private static void writeXML(Activity activity) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("playerSettings");
			doc.appendChild(rootElement);

			Element preferences = doc.createElement("preferences");
			rootElement.appendChild(preferences);


			SharedPreferences sharedPrefs = SharedPrefHelper.getSettings(activity);

			for (Pair<String, Object> p:ImportExportLists.getPreferencesList()) {
				Element pref = doc.createElement(p.first);


				if(p.second instanceof String){
					String res = sharedPrefs.getString(p.first, (String) p.second);
					pref.setAttribute("type","string");
					pref.setTextContent(res);
				}

				if(p.second instanceof Boolean){
					boolean res = sharedPrefs.getBoolean(p.first, (boolean)p.second);
					pref.setAttribute("type","boolean");
					pref.setTextContent(String.valueOf(res));
				}

				if(p.second instanceof Integer){
					int res = sharedPrefs.getInt(p.first, (int)p.second);
					pref.setAttribute("type","int");
					pref.setTextContent(String.valueOf(res));
				}

				preferences.appendChild(pref);
			}

			Element mediaLibrary = doc.createElement("mediaLibrary");
			rootElement.appendChild(mediaLibrary);

			MediaLibrary.Preferences mlPrefs= MediaLibrary.getPreferences(activity.getApplicationContext());

			Element bastp = doc.createElement("bastp");
			bastp.setTextContent(String.valueOf(mlPrefs.forceBastp));
			mediaLibrary.appendChild(bastp);

			Element groupByFolder = doc.createElement("groupByFolder");
			groupByFolder.setTextContent(String.valueOf(mlPrefs.groupAlbumsByFolder));
			mediaLibrary.appendChild(groupByFolder);


			Element excludedAlbums = doc.createElement("excludedAlbums");
			mediaLibrary.appendChild(excludedAlbums);

			for (String folderpath:mlPrefs.blacklistedFolders) {
				Element folder = doc.createElement("folder");
				folder.setTextContent(folderpath);
				excludedAlbums.appendChild(folder);
			}

			Element includedAlbums = doc.createElement("includedAlbums");
			mediaLibrary.appendChild(includedAlbums);

			for (String folderpath:mlPrefs.mediaFolders) {
				Element folder = doc.createElement("folder");
				folder.setTextContent(folderpath);
				includedAlbums.appendChild(folder);
			}

			// write the content into xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);


			StringWriter stringBuilder = new StringWriter();
			transformer.transform(source, new StreamResult(stringBuilder));
			Log.e(TAG, "export: "+stringBuilder.toString());


			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String fDate = sdf.format(new Date());

			writeFile("player_preferences"+fDate+".xml", stringBuilder.toString());
			Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.settings_export_toast_success)+" Downloads/player_preferences"+fDate+".xml", Toast.LENGTH_LONG).show();

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}


	private static void writeFile(String fileName, String content){
		File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
		try{
			if (!file.createNewFile()) {
				Log.e(TAG, "File not created!");
				return;
			}

			FileWriter writer = new FileWriter(file);
			writer.append(content);
			writer.flush();
			writer.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
