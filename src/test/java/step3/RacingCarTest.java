package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.Utils.getRandomNumber;

public class RacingCarTest {

  @DisplayName("전진 조건 테스트: Random에 대한 입력값이 4 이상일 때 전진")
  @ParameterizedTest
  @CsvSource({
    "0,0",
    "4,0",
    "5,1",
    "9,1",
  })
  void 전진_조건_테스트 (int n, int expected) {
    assertThat(Cars.moving(n)).isEqualTo(expected);
  }

  @DisplayName("포지션 테스트 : 현재 포지션을 문자열로 표현")
  @ParameterizedTest
  @CsvSource({
    "1,-",
    "2,--",
    "3,---",
  })
  void 포지션_테스트 (int position, String expected) {
    assertThat(Car.of(position).toString()).isEqualTo(expected);
  }

  @DisplayName("전진 테스트 : 자동차가 정상적으로 전진 되었는지 확인")
  @ParameterizedTest
  @CsvSource({
    "1,1,--",
    "2,2,----",
    "3,3,------",
  })
  void 전진_테스트 (int initPosition, int moving, String expected) {
    Car car = Car.of(initPosition);
    car.go(moving);
    assertThat(car.toString()).isEqualTo(expected);
  }

  @DisplayName("랜덤 넘버 테스트 : 10 이하의 수만 할당해야 함")
  @Test
  void 랜덤_넘버_테스트 () {
    for (int i = 0; i < 20000000; i++) {
      assertThat(getRandomNumber() < 10).isEqualTo(true);
    }
  }

  @DisplayName("자동차 Position 검증 테스트 : 초기 값은 0 이상만 가능")
  @ParameterizedTest
  @ValueSource(ints = { -1, -2 })
  void 포지션_검증_테스트 (int position) {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> Car.of(position));
  }

  @DisplayName("시도 횟수 검증 테스트 : 시도 횟수는 1 이상만 가능")
  @ParameterizedTest
  @ValueSource(ints = { 0, -1 })
  void 시도_횟수_검증_테스트 (int time) {
    List<Car> cars = new ArrayList<>();
    cars.add(Car.of(0));
    assertThatIllegalArgumentException()
      .isThrownBy(() -> Cars.of().startRace(cars, time));
  }
}
