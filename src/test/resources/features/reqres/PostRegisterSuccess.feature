Feature: TUGAS ALTA QE Batch 12 EKA
@Tugas
#  PositiveCase
  Scenario: Post Register a user with valid json
    Given Register a new user with valid json "RegisterSucces.json"
    When Send request post register user
    Then Status code should be 200 ok
    And Response body token was "QpwL5tke4Pnpja7X4"
    And Validate post register a users JSON schema "RegisterUserSchema.json"

  @Tugas
#  NegativeCase
  Scenario: Post Register a user without password
    Given Register a user without password "RegisterUnsuccess.json"
    When Send request post register user without password
    Then Status code should be 400
    And Response body token erorr message was "Missing password"
    And Validate login user without password "RegisterUnsuccesSchema.json"
