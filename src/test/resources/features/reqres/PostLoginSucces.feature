Feature: TUGAS ALTA QE Batch 12 EKA
@Tugas
#  Positive Case
  Scenario: Post Login a new user with valid json
    Given Login a new user with valid json "LoginSucces.json"
    When Send request post login user
    Then Status code should be 200
    And Validate post login a users JSON schema "LoginUserSchema.json"

@Tugas
# Negative Case
  Scenario: Post Login user with valid email without password
    Given Login user with valid email without password "LoginUnsuccess.json"
    When Send request post login user without password
    Then Status code should be 400
    And Response body token error message was "Missing password"
    And Validate post login user JSON schema "LoginUnsuccesSchema.json"