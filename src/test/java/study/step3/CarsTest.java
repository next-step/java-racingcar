package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.domain.CarMovableStrategy;
import study.step3.domain.Cars;
import study.step3.domain.MovableStrategy;

public class CarsTest {

  List<Car> carList = new ArrayList<>();

  int carNumber = 2;

  @BeforeEach
  void createCarList() {
    MovableStrategy movableStrategy = new CarMovableStrategy();

    for (int i = 0; i < carNumber; i++) {
      Car newCar = new Car(movableStrategy);

      carList.add(newCar);
    }
  }

  @DisplayName("입력한 숫자 수만큼의 car list를 Cars객체를 생성했을 때, cars의 car객체 숫자 테스트")
  @Test
  void createCars() {
    // when
    Cars cars = new Cars(carList);

    // then
    assertThat(cars.getCars().size()).isEqualTo(carNumber);
  }

}
