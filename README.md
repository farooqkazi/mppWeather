# mppWeather
Kotlin multiplatform app showcase, represent simple use case of sharing code between IOS and Android.

### Project structure
`SharedCode` module - right now presentation(ViewModel), business logic, network layer and serialization are shared between platforms. 

`app` module - android app project with UI code only.

`iosApp` module - xcode ios app project with UI code only.

### How to run project

IOS app: 

From project folder `./gradlew packForXcode` -> `open iosApp/githubIOS/githubIOS.xcodeproj` -> run project from xcode

Android app:
From project folder `./gradlew assembleDebug` -> apk will be available in `/app/build/outputs/apk/debug`
Alternatively just open whole project in android studio and run app module.
