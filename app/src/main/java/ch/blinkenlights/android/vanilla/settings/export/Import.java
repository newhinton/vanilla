package ch.blinkenlights.android.vanilla.settings.export;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Import extends Activity {

	private static final int READ_REQUEST_CODE = 314;
	private static final String TAG = "Importer";

	public static void importSettings(Activity a) {
		Log.e(TAG, "import!");
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
		Log.e(TAG, "import?");
	}

	public static void interpretResult(int reqCode, int resCode, Intent res, Activity a){
		if (reqCode == READ_REQUEST_CODE && resCode == Activity.RESULT_OK) {
			if (res != null) {
				Uri uri = res.getData();

				//File f = new File(new URI(uri.toString()));
				Log.i(TAG, "Uri toString: " + uri.toString());
				Log.i(TAG, "Uri absolute: " + uri.getEncodedPath());
				Log.i(TAG, "Uri     path: " + uri.getPath());
				//Log.i(TAG, "File    path: " + f.getAbsolutePath());

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
				Log.e(TAG, "imported: "+stringBuilder.toString());

			}
		}
	}
}
