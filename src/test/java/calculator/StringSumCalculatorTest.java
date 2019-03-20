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

  @Test
  public void test_oneInput_result() {

    // Given
    int oneNumber = 1;
    String oneNumberString = oneNumber + "";

    // When
    int result = StringSumCalculator.sum(oneNumberString);

    // Then
    assertThat(result).isEqualTo(oneNumber);
  }

  @Test
  public void test_multiInput_splitComma_result() {

    // Given
    int first = 1;
    int second = 2;
    String inputString = first + "," + second;

    // When
    int result = StringSumCalculator.sum(inputString);

    // Then
    assertThat(result).isEqualTo(first + second);
  }

  @Test
  public void test_multiInput_splitCommaAndColon_result() {

    // Given
    int first = 1;
    int second = 2;
    int third = 3;
    String inputString = first + "," + second + ":" + third;

    // When
    int result = StringSumCalculator.sum(inputString);

    // Then
    assertThat(result).isEqualTo(first + second + third);
  }

  @Test
  public void test_multiInput_customSeparator_result() {

    // Given
    int first = 1;
    int second = 2;
    int third = 3;
    String separator = ";";
    String inputString = "//" + separator + "\n"
        + first + separator + second + separator + third;

    // When
    int result = StringSumCalculator.sum(inputString);

    // Then
    assertThat(result).isEqualTo(first + second + third);
  }

  @Test(expected = RuntimeException.class)
  public void test_oneInput_negativeNumber_result() {

    // Given
    int first = -1;
    String inputString = first + "";

    // When
    StringSumCalculator.sum(inputString);
  }

  @Test(expected = RuntimeException.class)
  public void test_multiInput_negativeNumber_result() {

    // Given
    int first = -1;
    int second = 2;
    int third = 3;
    String inputString = first + "," + second + "," + third;

    // When
    StringSumCalculator.sum(inputString);
  }
}
