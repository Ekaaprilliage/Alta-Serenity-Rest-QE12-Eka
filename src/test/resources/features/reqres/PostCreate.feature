Feature: TUGAS ALTA QE BATCH 12 EKA
@Tugas @Latihan
#  Positive Case
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And Response body a name was "Eka Aprillia" and job was "QE Engineer"
    And Validate create a new user JSON schema "CreateUserSchema.json"

#  Negative Case
@Tugas
  Scenario: Post for new users without using a name
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And Response body a name was "" and job was "QE Engineer"
    And Validate create a new user JSON schema "CreateUserSchema.json"

