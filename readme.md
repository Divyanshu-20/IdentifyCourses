TOPIC:  FEATURED NEWS
------


CONTENTS OF THE FILE
---------------------

1. Team Members
2. Introduction
3. Description
4. Pre-requisites
5. Frameworks & Tools Used
6. To Run the Project
7. Report
8. Screenshots
9. Excel File and Text file to store information of featured News


Team Members:
--------------

2303771       - Sowmya Anugu
 
2303699       - Deepanshu Verma

2303908       - Kaustubh Kolekar 
   
2304066       - Divyanshu Dangore


Introduction:
-------------
The main objective of the project is to implement testing procedures to get the count and display the news information of each featured news and validate with tooltip. 
We have implemented POI, POM, Cucumber and TestNG.


Description:
------------
1. Navigate to be.cognizant portal
2. Capture user information from the top right corner and Verify the user information and print it in console.
3. Print the count of featured news present on the home page in console.
4. Print the featured news titles displayed on the  home page in console.
5. Verify title of the featured news with the tooltip for each featured news.
6. Click on each featured news and verify navigated to the correct news and verify tooltip.
7. Get all the information of the news and print it in console.
8. Then click on be.cognizant from news page and verify it is navigated to the be.cognizant Home page or not. And do the same process for each news.
9. Display all the apps under "Apps and Tools".


Pre-requisites:
----------------
URL : https://be.cognizant.com/


Frameworks & Tools Used:
------------------------
- TestNG 
- Cucumber
- POM 
- Extent Report
- Apache POI


To Run the Project:
--------------------
The following are the various ways to run the project:

 1.Run the testng.xml file using TestNG suite

 2.Run the testRun class using TestNG Test


Report:
--------
1.To access the generated cucumber Report, reach the "reports" Folder: /featuredNews_Project/reports/myreport.html.

2.To access the generated extent report,reach the "ExtentReports" Folder :  /featuredNews_Project/ExtentReports/SparkReport


Screenshots:
------------
To view the screenshots for each featured news after clicking on it, reach "screenshots" Folder: /featuredNews_Project/screenshots


Excel File and Text file to store information of featured News:
---------------------------------------------------------------
1.To view count and featured news title in excel file, reach to "src/test/resources" :  /featuredNews_Project/src/test/resources/newsData.xlsx.

2.To view content of each featured news, reach to "src/test/resources" : /featuredNews_Project/src/test/resources/newsTextFile.txt (or) view it in console