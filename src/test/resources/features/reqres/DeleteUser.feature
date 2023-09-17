Feature: TUGAS ALTA QE BATCH 12
@Tugas
  Scenario Outline: Delete a user with valid json and user id
    Given Delete a user with valid user id <id>
    When Send request delete user
    Then Status code should be 204 No Content
      Examples:
        | id |
        | 1  |

# negative case
  Scenario Outline: Delete a user with invalid parameter
    Given Delete a user with invalid user id <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id      |
      | kanna   |
      | @##$#%$ |