package step1;

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
  @DisplayName("Set 크기 확인")
  void setSizeTest() {
    assertThat(numbers.size())
        .isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set 포함 여부 확인 ValueSource")
  void setContainsValueSourceTest(int val) {
    assertThat(numbers.contains(val))
        .isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
  @DisplayName("Set 포함 여부 확인 CsvSource")
  void setContainsCsvSourceTest(int val, boolean expected) {
    assertThat(numbers.contains(val))
        .isEqualTo(expected);
  }
}
