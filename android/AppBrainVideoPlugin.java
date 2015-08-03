package com.elfiky.cordova.plugin.appbrain;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.appbrain.AppBrainBanner;

import android.util.Log;

public class AppBrainVideoPlugin extends CordovaPlugin {

	public static final String ACTION_SHOW_VIDEO_AD = "show_video";

	private final String TAG = "appbrain_log";

	private static final String DEFAULT_PLACEMENTID = "e5fe57df-9504-480a-a747-17a9f58bb562";

	/* options */
	private static final String OPT_PLACEMENTID = "placement_id";

	private String dev_placement_id = DEFAULT_PLACEMENTID;

	@Override
	public boolean execute(final String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (ACTION_SHOW_VIDEO_AD.equals(action)) {
			JSONObject options = data.optJSONObject(0);
			executeCreateInterstitialView(options, callbackContext);
		}

		return true;

	}

	private PluginResult executeCreateInterstitialView(JSONObject options,
			final CallbackContext callbackContext) {
		this.setOptions(options);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
                    addBanner();
					Log.v(TAG, "Show mobilecore ad Interstitial");
				} catch (Exception ex) {
					Log.e(TAG, "error error error error ");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}

    public void addBanner() {
        AppBrainBanner banner = new AppBrainBanner(getContext());
        cordova.getActivity().addView(banner);
    }

	private void setOptions(JSONObject options) {
		if (options == null)
			return;

		if (options.has(OPT_PLACEMENTID))
			this.dev_placement_id = options.optString(OPT_PLACEMENTID);
	}

}