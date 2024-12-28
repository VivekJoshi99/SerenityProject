Feature: Automation the functionality of booking an online ticket

  Background:
    Given I navigate to the ERAIL website

  @joshi
  Scenario: Validate train availability
    Given I have searched for trains between "Delhi" and "Mumbai" and selected 2 and 1 entry
    When I select the number 1 train from the list
    Then I should see the train's availability status

  @vcj
  Scenario: Validate the timetable of a specific train
    Given I have searched for trains between "Delhi" and "Chandigarh" and selected 2 and 1 entry
    When I select the number 2 train from the list
    And I click on the "Timetable" link
    Then I should see the timetable for the selected train

  @Chan
  Scenario: Download train timetable PDF and validate content
    Given I have searched for trains between "Delhi" and "Mumbai" and selected 2 and 1 entry
    When I select the number 1 train from the list
    And I click on the "Timetable" link
    And I download the timetable as a PDF
    Then the PDF should contain the expected timetable information
    And I delete the downloaded PDF file

  @smoke
  Scenario: Book an Online ticket for future customizable date
    When I enter "Delhi" as the source station and selected 4 th entry
    And I enter "Mumbai" as the destination station and selected 2 nd entry
    And I enter "21-Dec-24" as booking date
    And I select "Senior Citizens/Lower Berth" as Quota
    And I select "1A - First AC" as train type
    Then I click on "Get Trains"
