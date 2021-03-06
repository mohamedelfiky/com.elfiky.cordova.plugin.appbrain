var AppBrain = {

  initializeAppBrain: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'initSdk', []);
  },

  showBanner: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'showBanner', []);
  },

  showInterstitial: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'showInterstitial', []);
  },

  hideBannerView: function (successCallback, errorCallback) {
    return  cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'hideBannerView', []);
  }
};

module.exports = AppBrain;