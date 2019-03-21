package ch.blinkenlights.android.vanilla.settings.export;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import ch.blinkenlights.android.vanilla.PrefDefaults;
import ch.blinkenlights.android.vanilla.PrefKeys;

public class ImportExportLists {

	public static List<Pair<String,Object>> getPreferencesList() {

		ArrayList <Pair<String,Object>> result = new ArrayList<>();
		result.add(new Pair<String,Object>(PrefKeys.COVER_LONGPRESS_ACTION, PrefDefaults.COVER_LONGPRESS_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.COVER_PRESS_ACTION, PrefDefaults.COVER_PRESS_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.DEFAULT_ACTION_INT, PrefDefaults.DEFAULT_ACTION_INT));
		result.add(new Pair<String,Object>(PrefKeys.DEFAULT_PLAYLIST_ACTION, PrefDefaults.DEFAULT_PLAYLIST_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.COVERLOADER_ANDROID, PrefDefaults.COVERLOADER_ANDROID));
		result.add(new Pair<String,Object>(PrefKeys.COVERLOADER_VANILLA, PrefDefaults.COVERLOADER_VANILLA));
		result.add(new Pair<String,Object>(PrefKeys.COVERLOADER_SHADOW, PrefDefaults.COVERLOADER_SHADOW));
		result.add(new Pair<String,Object>(PrefKeys.COVERLOADER_INLINE, PrefDefaults.COVERLOADER_INLINE));
		result.add(new Pair<String,Object>(PrefKeys.COVER_ON_LOCKSCREEN, PrefDefaults.COVER_ON_LOCKSCREEN));
		result.add(new Pair<String,Object>(PrefKeys.DISABLE_LOCKSCREEN, PrefDefaults.DISABLE_LOCKSCREEN));
		result.add(new Pair<String,Object>(PrefKeys.DISPLAY_MODE, PrefDefaults.DISPLAY_MODE));
		result.add(new Pair<String,Object>(PrefKeys.DOUBLE_TAP, PrefDefaults.DOUBLE_TAP));
		result.add(new Pair<String,Object>(PrefKeys.ENABLE_SHAKE, PrefDefaults.ENABLE_SHAKE));
		result.add(new Pair<String,Object>(PrefKeys.HEADSET_ONLY, PrefDefaults.HEADSET_ONLY));
		result.add(new Pair<String,Object>(PrefKeys.HEADSET_PAUSE, PrefDefaults.HEADSET_PAUSE));
		result.add(new Pair<String,Object>(PrefKeys.IDLE_TIMEOUT, PrefDefaults.IDLE_TIMEOUT));
		result.add(new Pair<String,Object>(PrefKeys.LIBRARY_PAGE, PrefDefaults.LIBRARY_PAGE));
		result.add(new Pair<String,Object>(PrefKeys.MEDIA_BUTTON, PrefDefaults.MEDIA_BUTTON));
		result.add(new Pair<String,Object>(PrefKeys.MEDIA_BUTTON_BEEP, PrefDefaults.MEDIA_BUTTON_BEEP));
		result.add(new Pair<String,Object>(PrefKeys.NOTIFICATION_ACTION, PrefDefaults.NOTIFICATION_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.NOTIFICATION_VISIBILITY, PrefDefaults.NOTIFICATION_VISIBILITY));
		result.add(new Pair<String,Object>(PrefKeys.NOTIFICATION_NAG, PrefDefaults.NOTIFICATION_NAG));
		result.add(new Pair<String,Object>(PrefKeys.PLAYBACK_ON_STARTUP, PrefDefaults.PLAYBACK_ON_STARTUP));
		result.add(new Pair<String,Object>(PrefKeys.SCROBBLE, PrefDefaults.SCROBBLE));
		result.add(new Pair<String,Object>(PrefKeys.SHAKE_ACTION, PrefDefaults.SHAKE_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.SHAKE_THRESHOLD, PrefDefaults.SHAKE_THRESHOLD));
		result.add(new Pair<String,Object>(PrefKeys.STOCK_BROADCAST, PrefDefaults.STOCK_BROADCAST));
		result.add(new Pair<String,Object>(PrefKeys.SWIPE_DOWN_ACTION, PrefDefaults.SWIPE_DOWN_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.SWIPE_UP_ACTION, PrefDefaults.SWIPE_UP_ACTION));
		result.add(new Pair<String,Object>(PrefKeys.TAB_ORDER, PrefDefaults.TAB_ORDER));
		result.add(new Pair<String,Object>(PrefKeys.USE_IDLE_TIMEOUT, PrefDefaults.USE_IDLE_TIMEOUT));
		result.add(new Pair<String,Object>(PrefKeys.VISIBLE_CONTROLS, PrefDefaults.VISIBLE_CONTROLS));
		result.add(new Pair<String,Object>(PrefKeys.VISIBLE_EXTRA_INFO, PrefDefaults.VISIBLE_EXTRA_INFO));
		result.add(new Pair<String,Object>(PrefKeys.ENABLE_TRACK_REPLAYGAIN, PrefDefaults.ENABLE_TRACK_REPLAYGAIN));
		result.add(new Pair<String,Object>(PrefKeys.ENABLE_ALBUM_REPLAYGAIN, PrefDefaults.ENABLE_ALBUM_REPLAYGAIN));
		result.add(new Pair<String,Object>(PrefKeys.REPLAYGAIN_BUMP, PrefDefaults.REPLAYGAIN_BUMP));
		result.add(new Pair<String,Object>(PrefKeys.REPLAYGAIN_UNTAGGED_DEBUMP, PrefDefaults.REPLAYGAIN_UNTAGGED_DEBUMP));
		result.add(new Pair<String,Object>(PrefKeys.ENABLE_READAHEAD, PrefDefaults.ENABLE_READAHEAD));
		result.add(new Pair<String,Object>(PrefKeys.SELECTED_THEME, PrefDefaults.SELECTED_THEME));
		result.add(new Pair<String,Object>(PrefKeys.FILESYSTEM_BROWSE_START, PrefDefaults.FILESYSTEM_BROWSE_START));
		result.add(new Pair<String,Object>(PrefKeys.VOLUME_DURING_DUCKING, PrefDefaults.VOLUME_DURING_DUCKING));
		result.add(new Pair<String,Object>(PrefKeys.AUTOPLAYLIST_PLAYCOUNTS, PrefDefaults.AUTOPLAYLIST_PLAYCOUNTS));
		result.add(new Pair<String,Object>(PrefKeys.IGNORE_AUDIOFOCUS_LOSS, PrefDefaults.IGNORE_AUDIOFOCUS_LOSS));
		result.add(new Pair<String,Object>(PrefKeys.ENABLE_SCROLL_TO_SONG, PrefDefaults.ENABLE_SCROLL_TO_SONG));
		result.add(new Pair<String,Object>(PrefKeys.QUEUE_ENABLE_SCROLL_TO_SONG, PrefDefaults.QUEUE_ENABLE_SCROLL_TO_SONG));
		result.add(new Pair<String,Object>(PrefKeys.KEEP_SCREEN_ON, PrefDefaults.KEEP_SCREEN_ON));
		result.add(new Pair<String,Object>(PrefKeys.PLAYLIST_SYNC_MODE, PrefDefaults.PLAYLIST_SYNC_MODE));
		result.add(new Pair<String,Object>(PrefKeys.PLAYLIST_SYNC_FOLDER, PrefDefaults.PLAYLIST_SYNC_FOLDER));
		result.add(new Pair<String,Object>(PrefKeys.PLAYLIST_EXPORT_RELATIVE_PATHS, PrefDefaults.PLAYLIST_EXPORT_RELATIVE_PATHS));
		result.add(new Pair<String,Object>(PrefKeys.JUMP_TO_ENQUEUED_ON_PLAY, PrefDefaults.JUMP_TO_ENQUEUED_ON_PLAY));

		return result;
	}

}
