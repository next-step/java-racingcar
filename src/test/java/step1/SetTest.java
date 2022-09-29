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
  @DisplayName("요구사항1: Set 의 사이즈 확인")
  void sizeTest() {
    assertThat(numbers).hasSize(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("요구사항2: Set 이 1,2,3 값 존재하는지 확인")
  void containsUsingValue(int input) {
    assertThat(numbers).contains(input);
  }

  @ParameterizedTest
  @CsvSource(
      value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
      delimiter = ':')
  @DisplayName("요구사항3: Set 에 1,2,3 값 존재하고 4,5 값 존재하지 않는지 확인")
  void containsUsingCsv(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
