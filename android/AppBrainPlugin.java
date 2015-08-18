package com.elfiky.cordova.plugin.appbrain;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.appbrain.AppBrain;
import com.appbrain.AppBrainBanner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ViewGroup;

public class AppBrainPlugin extends CordovaPlugin {

	public static final String ACTION_INIT_SDK_AD = "initSdk";
	public static final String ACTION_SHOW_Banner_AD = "showBanner";
	public static final String ACTION_HIDE_Banner_AD = "hideBannerView";
	public static final String ACTION_SHOW_INTERSTITIAL_AD = "showInterstitial";
	public static AppBrainBanner last_bannar;

	private final String TAG = "appbrain_log";

	@Override
	public boolean execute(final String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (ACTION_SHOW_Banner_AD.equals(action)) {
			JSONObject options = data.optJSONObject(0);
			executeCreateBannerView(options, callbackContext);
		} else if (ACTION_INIT_SDK_AD.equals(action)) {
			AppBrain.init(cordova.getActivity());
		} else if (ACTION_SHOW_INTERSTITIAL_AD.equals(action)) {
			executeCreateInterstitialAd(callbackContext);
		}else if (ACTION_HIDE_Banner_AD.equals(action)) {
			hideBannerView(callbackContext);
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

	private PluginResult executeCreateInterstitialAd(
			final CallbackContext callbackContext) {

		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					AppBrain.getAds().showInterstitial(cordova.getActivity());
					
					Log.v(TAG, "Show appbrain Interstitial ad");
				} catch (Exception ex) {
					Log.e(TAG, "Error loading appbrain Interstitial");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}

	
	private PluginResult hideBannerView(
			final CallbackContext callbackContext) {

		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					ViewGroup viewGroup = (ViewGroup) ((ViewGroup) cordova.getActivity()
							.findViewById(android.R.id.content)).getChildAt(0);
					if(last_bannar != null){
						viewGroup.removeView(last_bannar);
					}
					
					Log.v(TAG, "Show appbrain Interstitial ad");
				} catch (Exception ex) {
					Log.e(TAG, "Error loading appbrain Interstitial");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}
	public void addBanner() {
		last_bannar = new AppBrainBanner(cordova.getActivity());

		ViewGroup viewGroup = (ViewGroup) ((ViewGroup) cordova.getActivity()
				.findViewById(android.R.id.content)).getChildAt(0);
		viewGroup.addView(last_bannar);
	}

}