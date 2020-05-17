package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step4.Utils.getRandomNumber;

public class RacingCarWinnerTest {

  @DisplayName("전진 조건 테스트: Random에 대한 입력값이 4 이상일 때 전진")
  @ParameterizedTest
  @CsvSource({
    "0,0",
    "4,0",
    "5,1",
    "9,1",
  })
  void 전진_조건_테스트 (int n, int expected) {
    assertThat(RacingCar.moving(n)).isEqualTo(expected);
  }

  @DisplayName("포지션 테스트 : 현재 포지션을 문자열로 표현")
  @ParameterizedTest
  @CsvSource({
    "1,Car : -",
    "2,Car : --",
    "3,Car : ---",
  })
  void Car_포지션_테스트 (int position, String expected) {
    assertThat(Car.of(position).toString()).isEqualTo(expected);
  }

  @DisplayName("Car 객체의 이름 테스트 : 이름이 정상적으로 할당 되는지 확인하는 테스")
  @ParameterizedTest
  @CsvSource({
    "Car1,Car1 : -",
    "Car2,Car2 : -",
    "Car3,Car3 : -",
  })
  void Car_이름_테스트 (String name, String expected) {
    assertThat(Car.of(name, 1).toString()).isEqualTo(expected);
  }

  @DisplayName("Car 객체의 이름 및 위치에 대한 테스트")
  @ParameterizedTest
  @CsvSource({
    "Car1,10,Car1 : ----------",
    "자동차,2,자동차 : --",
    "넥스트 스텝,5,넥스트 스텝 : -----",
  })
  void Car_객체_테스트 (String name, int position, String expected) {
    assertThat(Car.of(name, position).toString()).isEqualTo(expected);
  }

  @DisplayName("전진 테스트 : 자동차가 정상적으로 전진 되었는지 확인")
  @ParameterizedTest
  @CsvSource({
    "1,1,Car : --",
    "2,2,Car : ----",
    "3,3,Car : ------",
  })
  void 전진_테스트 (int initPosition, int moving, String expected) {
    Car car = Car.of(initPosition);
    car.going(moving);
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
      .isThrownBy(() -> RacingCar.of().racing(cars, time));
  }

  @DisplayName("단일 우승자의 경우에 대한 테스트")
  @Test
  void 단일_우승자_테스트 () {
    RacingCar racingCar = RacingCar.of();
    racingCar.setCars(Stream.of(
      Car.of("ExpectedWinner", 10),
      Car.of("runner", 0),
      Car.of("runner", 0)
    ).collect(Collectors.toList()));
    assertThat(racingCar.getWinners()).isEqualTo("ExpectedWinner");
  }

  @DisplayName("우승자가 여러 명일 경우에 대한 테스트")
  @Test
  void 다중_우승자_테스트 () {
    RacingCar racingCar = RacingCar.of();
    racingCar.setCars(Stream.of(
      Car.of("ExpectedWinner1", 10),
      Car.of("ExpectedWinner2", 10),
      Car.of("runner", 0)
    ).collect(Collectors.toList()));
    assertThat(racingCar.getWinners()).isEqualTo("ExpectedWinner1, ExpectedWinner2");
  }
}
