Feature: TUGAS ALTA QE Batch 12 EKA
# Positive
  @Tugas
  Scenario Outline: Get Single Resource user with valid parameter id
    Given Get Single Resource users with valid id <id>
    When Send Request get single resource
    Then Status codeget single resource should be 200 OK
    And Response body single resource should be <id>
    And Validate get single resource users JSON schema "SingleResourceSchema.json"
  Examples:
    | id |
    | 1  |
    | 2  |

# Negative Case
  Scenario Outline: Get Single Resource user with Invalid parameter id
    Given Get Single Resource users with invalid id <id>
    When Send Request get single resource
    Then Status code get single resource should be 404 Not Found
    And Validate get single resource users JSON schema "SingleResourceNotFoundSchema.json"
    Examples:
      | id |
      | 23 |