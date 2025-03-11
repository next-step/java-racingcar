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
  @DisplayName("요구사항1: Set의 크기를 확인하는 학습테스트")
  void size() {
    int size = numbers.size();
    assertThat(size).isEqualTo(3);
  }

  @ParameterizedTest
  @DisplayName("요구사항2: Set에 숫자 1, 2, 3 값이 존재하는지 테스트")
  @ValueSource(ints = {1, 2, 3})
  void contains_1(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest
  @DisplayName("요구사항3: 입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
  @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
  void contains_2(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

}
