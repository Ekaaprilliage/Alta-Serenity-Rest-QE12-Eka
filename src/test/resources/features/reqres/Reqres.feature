Feature: ALTA QE Batch 12
  @Latihan
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

  @Latihan
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And Response body name was "Eka Aprillia" and job was "QE Engineer"
    And Validate create a new user JSON schema "CreateUserSchema.json"

  @Latihan
  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<jsonFile>" and user id <id>
    When Send request put update user
    Then Status code should be 200 Created
    And Response body name was "<name>" and job was "<job>"
    And Validate update users JSON schema "UpdateUserSchema.json"
    Examples:
      | id | jsonFile         | name           | job           |  |
      | 1  | UpdateUser.json  | Eka Aprillia 1 | Update User 1 |  |
      | 2  | UpdateUser2.json | Eka Aprillia2  | Update User2  |  |
      | 3  | UpdateUser3.json | Eka Aprillia 3 | Update User 3 |  |

  @Latihan
  Scenario Outline: Delete a user with valid json and user id
    Given Delete a user with valid user id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
