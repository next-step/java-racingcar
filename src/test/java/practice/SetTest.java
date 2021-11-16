package practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  public void sizeTest() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void setTest(int input) {
    assertTrue(numbers.contains(input));
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
  public void setTest(String input, String expected) {
    String[] values = input.split(",");
    boolean expectedValue = Boolean.parseBoolean(expected);

    for (String value : values) {
      int num = Integer.parseInt(value);

      assertThat(numbers.contains(num)).isEqualTo(expectedValue);
    }
  }
}
