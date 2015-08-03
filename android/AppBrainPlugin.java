package com.elfiky.cordova.plugin.Appbrain;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.appbrain.AppBrain;
import com.appbrain.AppBrainBanner;

import android.util.Log;
import android.view.ViewGroup;

public class AppBrainPlugin extends CordovaPlugin {

	public static final String ACTION_INIT_SDK_AD = "initSdk";
	public static final String ACTION_SHOW_Banner_AD = "showBanner";
	public static final String ACTION_SHOW_INTERSTITIAL_AD = "show_interstital";

	private final String TAG = "appbrain_log";


	@Override
	public boolean execute(final String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (ACTION_SHOW_Banner_AD.equals(action)) {
			JSONObject options = data.optJSONObject(0);
			executeCreateBannerView(options, callbackContext);
		} else if (ACTION_INIT_SDK_AD.equals(action)) {
	        AppBrain.init(cordova.getActivity());
		}
		
		return true;

	}

	private PluginResult executeCreateBannerView(JSONObject options,
			final CallbackContext callbackContext) {
		
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
                    addBanner();
					Log.v(TAG, "Show appbrain banner ad");
				} catch (Exception ex) {
					Log.e(TAG, "Error loading appbrain banner");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}

    public void addBanner() {
        AppBrainBanner banner = new AppBrainBanner(cordova.getActivity());
        
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) cordova.getActivity().findViewById(android.R.id.content)).getChildAt(0);
        viewGroup.addView(banner);
    }


}