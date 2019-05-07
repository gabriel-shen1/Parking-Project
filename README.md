# Rutgers Software Engineering 2019 Spring

## Team Members:

* Suva Shahria
* Krithika Uthaman
* Andrew Schneeloch
* Josh LoGiudice
* Gabriel Shen
* Anthony Lau
* Jahidul Islam
* Yu Liu
* Max Davatelis

## Repository Structure
- `Doc/`contains all the reports, demo slides, and brochure.
- `Design/`contains the UML Diagrams from the reports.


## How to Run RUParking
RUParking is and Android app, which means the lastest version of Android Studio needs to be downloaded. The project file needs to be downloaded. If it is downlaoded as a zip file, it needs to be unzipped. Open Android Studio and select Import Project (Gradle, Eclipse, ADT, etc.). Navigate to where the project file is located and upload the entire folder. Once the build is complete, run the app. You will be prompted to select an AVD. If none exists, select create new virtual device. Select whichever device you would like and click next. Select the Pie release with API level 28, click next then finish. Now select the created AVD to run the app. Let the emulator install the apk. The app should open once it is finished.

One the main screen you will be able to either login or create a new account. One available login to use is
* Email: ss2@scarletmail.rutgers.edu
* Password: psw1

If this is giving you an invalid login notice, then click the initialize button and try again. Once logged in, you may select a campus to pick from. If you select Busch, it shows the lots on Busch you can park on. If you click on the names, it shows the location of the lot in google maps.

If you want to create a new account, click the create account button on the main screen. It will ask you to enter user information. For the campus information you need to enter Busch, Livi, or Colleve Ave. For the student or faculty section, enter either Student or Faculty, with capital first letters. Click register once all fields have been entered. You will be promted back to the login screen to login.
