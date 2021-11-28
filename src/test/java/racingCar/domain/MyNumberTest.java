package racingCar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyNumberTest {

  @Test
  @DisplayName("Test equals number.")
  public void testEqualsNumber() {
    assertEquals(new MyNumber(1), new MyNumber(1));
  }
}
