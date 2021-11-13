package carracing.domain;

import carracing.domain.entity.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

  Number number;

  @BeforeEach
  void setUp() {
    number = new Number(10);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 5, 10, 20, 16})
  @DisplayName("number의 생성자를 통해 int 값을 가진 객체로 생성이 되었는지 확인한다.")
  void createTest(int input) {
    assertThat( new Number(input).getValue()).isEqualTo(input);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:15", "15:25", "3:13", "8:18"}, delimiter = ':')
  @DisplayName("plus 연산을 통해 실제 값이 증가되었는지 확인한다.")
  void plusTest(int input, int result) {
    for (int i = 0; i < input; i++) {
      number.plus();
    }
    assertThat(number.getValue()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:5", "15:-5", "3:7", "8:2"}, delimiter = ':')
  @DisplayName("plus 연산을 통해 실제 값이 증가되었는지 확인한다.")
  void minusTest(int input, int result) {
    for (int i = 0; i < input; i++) {
      number.minus();
    }
    assertThat(number.getValue()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:true", "15:true", "0:false", "-8:false"}, delimiter = ':')
  @DisplayName("isGreaterThanZero를 통해 0보다 크면 true를 0이하 이면 false를 반환한다.")
  void isGreaterThanZeroTest(int input, boolean result) {
    number = new Number(input);
    assertThat(number.isGreaterThanZero()).isEqualTo(result);
  }

}
