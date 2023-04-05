package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

  @Test
  @DisplayName("Set의 size() 메소드는 중복을 허용하지 않는다.")
  void size() {
    // given
    int expected = 3;

    // when
    int result = numbers.size();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("ParameterizedTest 를 통해서 테스트 중복 코드 제거")
  void contains(int number) {
    // given
    boolean expected = true;

    // when
    boolean result = numbers.contains(number);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  @DisplayName("ParameterizedTest 를 통해서 테스트 중복 코드 제거, 실패 케이스도 포함")
  void contains2(int number) {
    // given
    boolean expected = number <= 3;

    // when
    boolean result = numbers.contains(number);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "1:true",
      "2:true",
      "3:true",
      "4:false",
      "5:false"
  }, delimiter = ':')
  @DisplayName("ParameterizedTest 를 통해서 테스트 중복 코드 제거, 실패 케이스도 포함 (CSVSource 사용)")
  void contains(int number, boolean expectedResult) {
    // given
    boolean expected = expectedResult;

    // when
    boolean result = numbers.contains(number);

    // then
    assertThat(result).isEqualTo(expected);
  }
}
