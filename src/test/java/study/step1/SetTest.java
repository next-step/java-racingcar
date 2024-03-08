package study.step1;

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
  @DisplayName("[요구사항1] Set의 size() 메소드를 활용해 numbers의 크기를 확인하는 테스트")
  void setSizeTest() {
    assertThat(numbers).hasSize(3);
  }

  @Test
  @DisplayName("[요구사항2] contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
  void containsTest() {
    assertThat(numbers).contains(1);
    assertThat(numbers).contains(2);
    assertThat(numbers).contains(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("[요구사항2] contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
  void parameterizedTest(int input) {
    assertThat(numbers).contains(input);
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("[요구사항3] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
  void parameterizedTestV2(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
