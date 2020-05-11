package step2;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void ScanTest () {
    String input = "2 + 3 * 4 / 2";
    StringCalculator calculator = new StringCalculator(input);
  }
}
