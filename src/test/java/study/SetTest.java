package study;

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
  void setUpTest() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("Set의 size() 메서드 테스트")
  void setSizeTest() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest(name = "contains()를 통해 numbers에 {0}이 포함되어있는지 테스트")
  @ValueSource(ints = {1, 2, 3})
  void containsTest(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest(name = "numbers에 {0}의 포함여부 {1} 테스트")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void containsTest2(int inputNumber, boolean expected) {
    assertThat(numbers.contains(inputNumber)).isEqualTo(expected);
  }
}
