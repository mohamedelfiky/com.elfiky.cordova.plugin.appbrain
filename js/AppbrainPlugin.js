var AppBrain = {

  initializeAppBrain: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'initSdk', []);
  },

  showPopup: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'showBanner', []);
  },

  showPopup: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainPlugin', 'showBanner', []);
  }
};

module.exports = AppBrain;