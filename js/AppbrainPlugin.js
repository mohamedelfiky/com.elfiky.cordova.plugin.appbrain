var Appnext = {

  initializeWithPlacementID: function (placementID, successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'Appnext', 'initializeWithPlacementID', [placementID]);
  }
  , showPopup: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'Appnext', 'showPopup', []);
  }
  , hidePopup: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'Appnext', 'hidePopup', []);
  }
  , cacheAd: function (successCallback, errorCallback) {
    return cordova.exec(successCallback, errorCallback, 'Appnext', 'cacheAd', []);
  }
  , isVisible: function (successCallback) {
    return cordova.exec(successCallback, null, 'Appnext', 'isVisible', []);
  }
  , setAdsCallback: function (successCallback, failureCallback) {
    return cordova.exec(successCallback, failureCallback, 'Appnext', 'setAdsCallback', []);
  }
  , showVideo: function (successCallback, failureCallback,options) {
    return cordova.exec(successCallback, failureCallback, 'AppNextVideoPlugin', 'show_video', options);
  }
};

module.exports = Appnext;