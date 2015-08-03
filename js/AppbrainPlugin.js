var AppBrain = {

  initializeAppBrain: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainVideoPlugin', 'AppBrainVideoPlugin', []);
  }
  , showPopup: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'AppBrainVideoPlugin', 'showPopup', []);
  }
};

module.exports = AppBrain;