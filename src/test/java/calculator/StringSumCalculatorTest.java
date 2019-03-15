package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StringSumCalculatorTest {

  @Test
  public void test_empty_result_0() {

    // Given
    String empty = "";

    // When
    int result = StringSumCalculator.sum(empty);

    // Then
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void test_null_result_0() {

    // Given
    String nullString = null;

    // When
    int result = StringSumCalculator.sum(nullString);

    // Then
    assertThat(result).isEqualTo(0);
  }
}
