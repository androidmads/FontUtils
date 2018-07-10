# FontUtils
A Tiny Font Utility Library used to apply custom Fonts to 
* Toolbar
* NavigationView
* Menu
* Submenu
* TabLayout
* RadioGroup
* Other Views like EditText, TextView, etc.

## Supported Android Languages
- [x] Java
- [x] Kotlin
- [x] Xamarin

Readme for Xamarin.Android can be found here https://github.com/Xamarin-Gists/XAFontUtilsLibrary.

[![Support Me](https://www.ko-fi.com/img/donate_sm.png)](https://ko-fi.com/T6T0A1CC)

## Versions
* 1.0.2 Added Support for TabLayout and RadioGroup

## How to download
Add this line in your app level gradle file (build.gradle)

```java
implementation 'com.ajts.androidmads.fontutils:fontutils:1.0.2'
```

## How to use
### Java
```java
// Applying Custom Font
Typeface typeface = Typeface.createFromAsset(getAssets(), "custom_font.ttf");
// Init Library
FontUtils fontUtils = new FontUtils();
// Apply font to Toolbar
fontUtils.applyFontToToolbar(toolbar, typeface);
// Apply font to NavigationView
fontUtils.applyFontToNavigationView(navigationView, typeface);
// Apply font to Menu
fontUtils.applyFontToMenu(menu, typeface);
// Apply font to Other Views like TextView...
fontUtils.applyFontToView(textview, typeface);
fontUtils.applyFontToView(editText, typeface);
fontUtils.applyFontToView(radioButton, typeface);
fontUtils.applyFontToView(checkBox, typeface);

fontUtils.applyFontToTabLayout(tabLayout, typefaceLight);
fontUtils.applyFontToRadioGroup(radioGroup, typefaceLight);
```
### Kotlin
```
// Applying Custom Font
val typeface = Typeface.createFromAsset(assets, lato_bold)
// Init Library
val fontUtils = FontUtils()
// Apply font to Toolbar
fontUtils.applyFontToToolbar(toolbar, typeface)
// Apply font to NavigationView
fontUtils.applyFontToNavigationView(navigationView, typeface)
// Apply font to Menu
fontUtils.applyFontToMenu(menu, typeface)
// Apply font to Other Views like TextView...
fontUtils.applyFontToView(textview, typeface)
fontUtils.applyFontToView(editText, typeface)
fontUtils.applyFontToView(radioButton, typeface)
fontUtils.applyFontToView(checkBox, typeface)

fontUtils.applyFontToTabLayout(tabLayout, typefaceLight)
fontUtils.applyFontToRadioGroup(radioGroup, typefaceLight)
```
## License
```
MIT License

Copyright (c) 2018 AndroidMad / Mushtaq M A

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
