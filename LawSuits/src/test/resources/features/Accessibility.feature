Feature: Accessibility
@Test
  Scenario: HomePage
    Given Launch LawSuit Application
    When Verify Recent LawSuits	available
    Then Get Recent LawSuit Details and Validate Summary
    
