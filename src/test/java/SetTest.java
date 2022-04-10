import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
  void size() {
    assertThat(numbers).hasSize(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void contains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("Set에 존재하는 input에 대해서는 true, 존재하지 않는 input에 대해서는 false를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
  void contains(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
