package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

  Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("만들어진 numbers의 크기는 3이 맞는지 확인")
  void numbersSize() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @DisplayName("numbers에 1, 2, 3이 존재하는지 확인")
  @ValueSource(ints = {1, 2, 3})
  void numbersContains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }
}
