Introduction
This demo project is an example to demonstrate the features of the Agconnect Crash Service Xamarin Android Plugin.

Installation

In the Solution Explorer panel, right click on the solution name and select Manage NuGet Packages. Search for Huawei.Agconnect.AgconnectCrash and install the package into your Xamarin.Android projects.

Place your agconnect-services.json file inside the project

Step 1: Sign in to AppGallery Connect and select your project from My Projects. Then go to Project Settings tab. On the page that is displayed, click agconnect-services.json button.

Step 2: Once you download your agconnect-services.json file, place it under the Assets folder of the demo project.

Step 3: Package name in the agconnect-services.json and the package name in the AndroidManifest.xml file should be same

Environment Setting

Android 4.2 JellyBean (API level 17) and later versions

A minimum version of Visual Studio 2019 16.3 or Visual Studio for Mac 2019 8.3 are required to build and compile


Testing Steps
Step 1: Tap makeException to trigger a non-fatal exception event, Tap CustomReport to generate a custom crash report, tap makeCrash to trigger a crash, and re-launch the app

Step 2: Login AGC webpage to check crash report.

Licensing and Terms
Agconnect Crash Service Xamarin Android Plugin - Demo is licensed under Apache 2.0 license