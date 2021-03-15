package study.step1;

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

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetCollectionTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("요구사항 1, Set의 크기 확인")
  @Test
  void setCheckSize() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("요구사항 2, Set의 1,2,3값 확인")
  @Test
  void containsNumber() {
    assertTrue(numbers.contains(1));
    assertTrue(numbers.contains(2));
    assertTrue(numbers.contains(3));
  }

  @DisplayName("요구사항 2, Set의 1,2,3값 확인, ParameterizedTest로 중복코드 제거")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void someNumbers_IsContains(int number) {
    assertTrue(numbers.contains(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5 })
  void someNumbers_IsContainsAndNotContains(int number) {
    assertTrue(numbers.contains(number));
  }

  @DisplayName("요구사항 3, Set의 1,2,3값 확인, ParameterizedTest로 입력 값이 다른 경우")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void intValue_IsContainsExpectedBooleanValue(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

}
