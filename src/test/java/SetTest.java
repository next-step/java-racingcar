import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  // Test Case 구현
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void containsWithValueSource(int input) {
    assertThat(numbers).contains(input);
  }

  @ParameterizedTest
  @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiterString = ":")
  void containsWithCsvSource(String input, String expected) {
    assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.valueOf(expected));
  }
}
