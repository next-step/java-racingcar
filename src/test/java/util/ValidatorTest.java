package util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

  @Test
  void validate_통과() {
    assertDoesNotThrow(() -> Validator.validateArgument(
        1,
        (arg) -> arg > 0,
        "errorMessage"
    ));
  }

  @Test
  void validate_실패() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Validator.validateArgument(
        1,
        (arg) -> arg < 0,
        "errorMessage"
    ));
  }
}
