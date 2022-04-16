import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArgumentValidatorTest {

  @Test
  void validate_통과() {
    assertDoesNotThrow(() -> ArgumentValidator.validate(
        1,
        (arg) -> arg > 0,
        "errorMessage"
    ));
  }

  @Test
  void validate_실패() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ArgumentValidator.validate(
        1,
        (arg) -> arg < 0,
        "errorMessage"
    ));
  }
}
