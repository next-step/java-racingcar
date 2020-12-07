package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
  }

  // Test Case 구현
  @Test
  void checkSize() {
    assertThat(numbers.size()).isEqualTo(4);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void containsFactor(int factor) {
    assertThat(numbers.contains(factor)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:4", "3:5"}, delimiter = ':')
  void input_shouldBeFalse(String input, String expected) {
    String actualValue = input.toLowerCase();
    String expectedValue = expected.toLowerCase();

    assertEquals(actualValue, expectedValue);
  }

}
