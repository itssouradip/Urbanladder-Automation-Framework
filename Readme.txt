
Problem Statement : Display Bookshelves
Website           : "https://www.urbanladder.com/"
---------------------------------------------------------------------

1) Display the name, price of first 3 bookshelves below Rs. 15000 with the following filters:
	
	* Storage type as 'Open'
	* Exclude out of stock bookshelves

2) From the menu, retrieve all the sub-menu items under 'Home Decor' and store it in a list. Display the same in console.

3) From the Gift Cards, choose "Birthday/Anniversary".
	* Fill the customize the gift cards section
	* Fill the form to detais with any one input invalid
	* Capture and display the error message



Steps of the Procedure:
----------------------------------------------------------------------

1)  Launch any browser (In this code we have used Chrome browser and Microsoft Edge browser). 
2)  Goto “https://www.urbanladder.com/”. 
3)  Scroll the page and click on ‘Bookshelves’ option. (It will take user to ‘Bookshelves’ page).
4)  Drag and drop the ‘price’ slider to Rs.15000.
5)  Choose ‘Storage Type’ as ‘Open’.
6)  Select the ‘Exclude Out Of Stock’ checkbox field.
7)  Take the list of first 3 bookshelves and print it on the console.
8)  Go to the 'Home Decor' menu under Lighting and Decor
9)  Take the list of all sub-menu items under the 'Home Decor' menu. 
10) Scroll the page up and click on ‘Gift Cards’ Option. (It will take user to ‘Gift Cards’ page).
11) Click on the ‘Birthday/Anniversary’ option.
12) Scroll up and select the 'GiftCards' option. This will redirect us to the GiftCards page.
13) Fill in the required details in the Customize giftcards page. (Select the value of the gift card and the date)
14) Click on Next. (It will navigate to the Sender and Recipient details section)
15) Fill in the Recipient's details.
16) Fill in the Sender's details with atleast one input as invalid.
17) Click on Next.
18) Capture the error message shown and print it in the console.

Folders
----------------------------------------------------------------------

1) src/test/java
       (package) pageObjects
            	- BookShelvesPage.java 
           		- GiftCardsPage.java
           		- HomePage.java

       (package) testBase
            	- BaseClass.java
            	- BasePage.java
            
       (package) testScenarios
            	- NavigateToBookshelvesPage.java
				- VisibilityOfBookshelvesFilters.java
				- SettingTheRequiredFilters.java
				- DisplayBookShelvesDetails.java
				- GetListOfSubMenuItems.java
				- GiftCardCustomization.java
				- RecipientAndSenderDetails.java
				- ResipientAndSenderDetailsDDT.java
				- EndToEnd.java

       (package) utilities
            	- AddFluentWait.java
            	- DataProviders.java
            	- ExcelUtility.java
            	- ExtentReportManager.java
            	- PropertyReader.java
            	- RandomInputGenerator.java
            	
2) src/test/resources
			- config.properties
			- log4j2.xml

3) dataTables
   			- testResults.xlsx (List of retrieved data is stored here)

4) reports
			- Extent Reports are saved here
      
5) screenshots
			- Screenshots are saved here
     
6) testData
			- RecipientAndSenderDetails.xlsx (used for filling up recipient and sender details in data driven approach)


Data Driven Concepts
-----------------------------------------------------------------------
1) Properties File (Reading Data)

   	config.properties
		- This properties file is present in src/test/resources        
   		- This file conists of application URL, address to fill in the giftcards form and pincode.
		- This file also consists of the environment on which to run the program - local or remote

2) Excel File (Reading data)
	
	RecipientAndSenderDetails.xlsx
		- Sheet: SenderDetails: Contains the Sender Name, Sender Email, Sender Mobile Number, Sender Address columns with one invalid input in each row.
		- Sheet: RecipientDetails: Contains the Recipient Name, Recipient Email and Recipient Mobile Number columns with valid input.

2) Excel File (Writing data)
	
	testResult.xlsx
		- Sheet: BookShelvesDetails: Storing the list of the first three bookshelves under Rs. 15000, with storage type 'Open' and excluding 'Out of Stock'
		- Sheet: SubMenuItems: Storing the list of sub-menu items under the 'Home Decor' menu.	
   	

Key Automation Scope
-------------------------------------------------------------------------

-> Using drag & drop
-> Locating elements precisely.
-> Using appropriate synchronization technique.
-> Extracting menu items & store in collections
-> Scrolling up and down in web page
-> Filling form (in different objects in web page)
-> Capture warning message   
-> Taking Screenshots

Technology/Automation Tools Used
-------------------------------------------------------------------------
1) Selenium Webdriver and it's concepts.
2) Maven
3) TestNG framework and it's concepts.
4) Data Driven approach
5) Page Object Model
6) Extent Report/ TestNG Report
7) Excel and Property file concepts
8) Multiple Browser testing concepts
9) Java Concepts   