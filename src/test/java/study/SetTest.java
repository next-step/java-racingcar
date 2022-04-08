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
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
  void sizeTest() {
    assertThat(numbers).hasSize(3);
  }

  @ParameterizedTest
  @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
  @ValueSource(strings = {"1", "2", "3"})
  void containsTest(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest
  @DisplayName("Set 에 존재/존재하지 않는 값들에 대해 확인")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void containsTrueFalseTest(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}