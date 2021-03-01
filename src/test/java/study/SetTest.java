package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @DisplayName("[요구사항 1] Set 크기 확인 테스트")
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest(name = "[요구사항 2] Set contains()를 통한 값 존재 확인 테스트-{index}")
  @ValueSource(ints = {1, 2, 3})
  void contains(int number) {
    assertTrue(numbers.contains(number));
  }

  @ParameterizedTest(name = "[요구사항 3] Set 존재하지 않는 값에 대한 실행 결과 예상 테스트-{index}")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void contain(int number, boolean expected) {
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }
}