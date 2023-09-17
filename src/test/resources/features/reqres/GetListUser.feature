Feature: ALTA QE Batch 12
#  Positive Case
  @Tugas @Latihan
  Scenario Outline: Get List user with valid parameter page
    Given Get List users with valid parameter page <page>
    When Send Request get list users
    Then Status code should be 200 ok
    And Response body page should be <page>
    And Validate get list users JSON schema "ListUsersSchema.json"
    Examples:
      |page|
      |1   |
      |2   |

#    Negative Case
  @Tugas
  Scenario Outline: Get List user with valid parameter page
    Given Get List users with valid parameter page <page>
    When Send Request get list users
    Then Status code should be 404
    Examples:
      | page |
      | 100  |
