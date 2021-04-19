package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.controller.CarRaceController;
import study.step3.domain.Car;

public class CarRaceControllerTest {

  @DisplayName("자동차 1대를 4회 만큼 이동했을 때, 위치를 이동하는지 테스트")
  @Test
  void carRacingGameWhenOneCarRacing() {
    // given
    String[] names = new String[]{"Kim"};
    int times = 4;

    // when
    CarRaceController carRaceController = new CarRaceController();
    List<Car> cars = carRaceController.start(names, times);

    // then
    assertThat(cars.get(0).curPosition()).isGreaterThan(0);
  }

  @DisplayName("자동차 댓수와 반복 횟수를 0으로 입력했을때, 경주가 실패하는지 테스트")
  @Test
  void carRacingGameWhenNoCar() {
    // given
    String[] names = new String[]{""};
    int times = 0;
    Car car = new Car(0);

    // when
    CarRaceController carRaceController = new CarRaceController();
    List<Car> cars = carRaceController.start(names, times);
    Car movedCar = cars.get(0);

    // then
    assertThat(movedCar).isEqualTo(car);
  }

}
