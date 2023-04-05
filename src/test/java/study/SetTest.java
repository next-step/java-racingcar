package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
  @DisplayName("Set의 크기 확인 테스트")
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set의 1, 2, 3 값 존재 확인 테스트")
  void contains(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("Set의 입력값에 따른 결과값 확인 테스트")
  void contains_true_or_false(int number, boolean expected) {
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }
}
