Feature: Featured News Information

  Scenario: Login to be.cognizant portal
    Given User navigate to be.cognizant portal
    When User enters the valid Username and click on Next button
    When User enters the valid Password and Click on the signin button
    And User enters the authentication code
    Then User should be redirected to be cognizant page
    When User click on Account manager icon
    And Capture the user information from Account manager frame
    Then Verify the user information with username and userid

  Scenario: counting and printing the featured news of Be.cognizant homepage
    Given User navigate to be.cognizant page
    And Featured news section should be displayed on Be.cognizant homepage
    When Print count of total number of featured news displayed on Be.cognizant homepage
    And Print the news title of all featured news displayed on Be.cognizant homepage
    Then Verify tooltip with respective news title for each featured news of be.cognizant homepage.
    When Print the information inside each News 

  Scenario: Display Apps and Tools Section on Be.cognizant homepage
    Then Verify the apps under Apps and Tools are displayed on Be.cognizant homepage.
    When print all Apps under Apps and Tools Header of Homepage
