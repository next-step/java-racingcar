package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

  @DisplayName("요구사항 1: Set 컬렉션의 사이즈를 확인한다")
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
    assertThat(numbers.size()).isNotEqualTo(4);
  }

  @DisplayName("요구사항 2: Set 컬렉션에 대한 학습 테스트")
  @Test
  void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @DisplayName("요구사항 3: @ParameterizedTest 학습테스트")
  @ParameterizedTest(name = "{index} => element={0}, expectedResult={1}")
  @CsvSource({
      "1, true",
      "2, true",
      "3, true",
      "4, false",
      "5, false"
  })
  void contains(int element, boolean expectedResult) {
    assertThat(numbers.contains(element)).isEqualTo(expectedResult);
  }

}
