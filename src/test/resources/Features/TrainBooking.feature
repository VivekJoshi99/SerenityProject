Feature: Automation the functionality of booking an online ticket

  Scenario: Validate train availability
    Given I have searched for trains between "Delhi" and "Mumbai"
    When I select the first train from the list
    Then I should see the train's availability status

  Scenario: Validate the timetable of a specific train
    Given I have searched for trains between "Delhi" and "Mumbai"
    When I select the first train from the list
    And I click on the "Timetable" link
    Then I should see the timetable for the selected train

  Scenario: Download train timetable PDF and validate content
    Given I have searched for trains between "Delhi" and "Mumbai"
    When I select the first train from the list
    And I click on the "Timetable" link
    And I download the timetable as a PDF
    Then the PDF should contain the expected timetable information
    And I delete the downloaded PDF file

  Scenario: Book an Online ticket for future customizable date
    Given I navigate to the ERAIL website
    When I enter "Delhi" as the source station
    And I enter "Mumbai" as the destination station
    And I enter "08-June" as booking date
    And I select "Senior Citizens/Lower Berth" as Quota
    And I select "1A - First AC" as train type
    Then I click on "Get Trains"
