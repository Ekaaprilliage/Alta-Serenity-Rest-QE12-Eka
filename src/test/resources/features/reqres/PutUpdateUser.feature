Feature: TUGAS ALTA QE BATCH 12 EKA
#  Positive Case
  @Tugas
  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<jsonFile>" and user id <id>
    When Send request put update user
    Then Status code should be 200 oK
    And Response body name was "<name>" and job was "<job>"
    And Validate update users JSON schema "UpdateUserSchema.json"
    Examples:
      | id | jsonFile         | name           | job           |
      | 1  | UpdateUser.json  | Eka Aprillia 1 | Update User 1 |
      | 2  | UpdateUser2.json | Eka Aprillia2  | Update User2  |
      | 3  | UpdateUser3.json | Eka Aprillia 3 | Update User 3 |

  @Tugas
# Negative Case
 Scenario Outline: Put update user with invalid user id and one request not found
   Given Update user with valid json "<jsonFile>" and user id <id>
   When Send request put update user
   Then Status code should be 200 oK
    Examples:
      | id  | jsonFile         |
      | 1   | UpdateUser.json  |
      | 2   |                  |
      | 100 | UpdateUser3.json |
