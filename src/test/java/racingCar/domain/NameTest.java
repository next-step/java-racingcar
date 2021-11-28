package racingCar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @Test
  @DisplayName("Test throws exception when name's length is over 5.")
  public void testNameLength() {
    assertThrows(IllegalArgumentException.class, () -> new Name("abcdef"));
  }

  @Test
  @DisplayName("Test equals name object.")
  public void testEquals() {
    Name name1 = new Name("abcd");
    Name name2 = new Name("abcd");

    assertEquals(name1, name2);
  }
}
