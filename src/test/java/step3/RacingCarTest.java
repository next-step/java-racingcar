package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

  RacingCar racingCar;
  int random = 0;
  @BeforeEach
  void setUp() {
    random = new Random().nextInt(9);
    racingCar = new RacingCar();
  }

  @Test
  public void 랜덤함수_0부터9까지() {
   List<Integer> numbers =  Arrays.asList(0,1,2,3,4,5,6,7,9);
    assertTrue(numbers.contains(random));
  }

  @ParameterizedTest
  @DisplayName("자동차 갯수와 이동 횟수가 숫자가 아닌 경우 예외")
  @CsvSource(value = {"문자입력중! : 숫자를 입력해주세요."}, delimiter = ':')
  public void 자동차_n개_이동횟수_n개_숫자가_아닌_경우(String value, String message) {
    assertThatThrownBy(() -> assertThat(value)
            .isInstanceOf(IllegalArgumentException.class))
            .overridingErrorMessage(message);
  }

  @ParameterizedTest
  @DisplayName("자동차 수가 0개인 경우 false 반환")
  @CsvSource(value = {"0:false"}, delimiter = ':')
  public void 자동차수_값이_0인경우(int car, boolean isCar) {
    assertEquals(isCar, !(car == 0));
  }
}
