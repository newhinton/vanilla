package ch.blinkenlights.android.vanilla.settings.export;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ch.blinkenlights.android.vanilla.SharedPrefHelper;

public class Import extends Activity {

	private static final int READ_REQUEST_CODE = 314;
	private static final String TAG = "Importer";

	public static void importSettings(Activity a) {
		//Log.e(TAG, "import!");
		performFileSearch(a);
	}

	/**
	 * Fires an intent to spin up the "file chooser" UI and select an image.
	 */
	public static void performFileSearch(Activity a) {

		// ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
		// browser.
		Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

		// Filter to only show results that can be "opened", such as a
		// file (as opposed to a list of contacts or timezones)
		intent.addCategory(Intent.CATEGORY_OPENABLE);

		// Filter to show only images, using the image MIME data type.
		// If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
		// To search for all documents available via installed storage providers,
		// it would be "*/*".
		intent.setType("text/xml");
		a.startActivityForResult(intent, READ_REQUEST_CODE);
	}

	public static void interpretResult(int reqCode, int resCode, Intent res, Activity a){
		if (reqCode == READ_REQUEST_CODE && resCode == Activity.RESULT_OK) {
			if (res != null) {
				Uri uri = res.getData();

				StringBuilder stringBuilder = new StringBuilder();
				try {
					InputStream inputStream = a.getContentResolver().openInputStream(uri);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						stringBuilder.append(line).append("\n");
					}
					bufferedReader.close();
					inputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//Log.e(TAG, "imported: "+stringBuilder.toString());
				try {
					extractSettings(stringBuilder.toString(), a);
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void extractSettings(String dom, Activity a) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(dom)));

		Element root = document.getDocumentElement();

		NodeList prefs = root.getChildNodes();

		SharedPreferences.Editor settings = SharedPrefHelper.getSettings(a).edit();

		for (int j = 0; j < prefs.getLength(); j++) {
			if(prefs.item(j).getNodeName().equals("preferences")){
				NodeList preferences = prefs.item(j).getChildNodes();
				for (int i = 0; i < preferences.getLength(); i++) {
					Node n = preferences.item(i);
					if (n.getNodeType() == Node.ELEMENT_NODE) {
						Element elem = (Element) n;
						String type = elem.getAttribute("type");
						if(type.equals("boolean")){
							settings.putBoolean(n.getNodeName(), Boolean.valueOf(n.getTextContent()));
						}
						if(type.equals("int")){
							settings.putInt(n.getNodeName(), Integer.valueOf(n.getTextContent()));
						}
						if(type.equals("string")){
							settings.putString(n.getNodeName(), n.getTextContent());
						}
					}

				}
			}
		}
		settings.apply();
	}
}
