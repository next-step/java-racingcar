package util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
  
  private static final String AN_ERROR_MESSAGE = "errorMessage"; 

  @Test
  void validate_통과() {
    // given
    int argument = 1;
    Predicate<Integer> predicate = (arg) -> arg > 0;
    
    // then
    assertDoesNotThrow(() -> Validator.validateArgument(
        argument,
        predicate,
        AN_ERROR_MESSAGE
    ));
  }

  @Test
  void validate_실패() {
    // given
    int argument = 1;
    Predicate<Integer> predicate = (arg) -> arg < 0;

    // then
    assertThrows(
        IllegalArgumentException.class,
        () -> Validator.validateArgument(
            argument,
            predicate,
            AN_ERROR_MESSAGE
    ));
  }
}
