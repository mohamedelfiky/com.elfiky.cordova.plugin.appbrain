# AppBrain ads cordova plugin
a cordova plugin to integerate appbrain ads with your phonegap application

You can manage some types of Ads .

  - Interstitial ad
  - banner ad


### Version
1.0

### Installation

```sh
$ cordova plugin add https://github.com/mohamedelfiky/com.elfiky.cordova.plugin.appbrain.git
```

### Examples

Initialize Appbrain
```js
Appbrain.initializeAppBrain(success, failure);
```

show Interstitial ad
```js
Appbrain.showInterstitial(success, failure);
```

show banner ad
```js
Appbrain.showBanner(success, failure);
```

hide banner ad
```js
Appbrain.hideBannerView(success, failure);
```
