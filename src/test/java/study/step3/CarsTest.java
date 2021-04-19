package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.domain.Cars;
import study.step3.domain.MovableStrategy;

public class CarsTest {


  public static Cars makeCars(int carNumber, int randomNumber) {
    List<Car> carList = new ArrayList<>();

    MovableStrategy movableStrategy = () -> randomNumber >= 4;

    for (int i = 0; i < carNumber; i++) {
      Car newCar = new Car(movableStrategy);

      carList.add(newCar);
    }

    return new Cars(carList);
  }

  @DisplayName("입력한 숫자 수만큼의 car list를 Cars객체를 생성했을 때, cars의 car객체 숫자 테스트")
  @Test
  void createCars() {
    //given
    int carNumber = 2;
    int randomNumber = (int) (Math.random() * 10 + 4);

    // when
    Cars cars = makeCars(carNumber, randomNumber);

    // then
    assertThat(cars.getCars().size()).isEqualTo(carNumber);
  }

  @DisplayName("랜덤 숫자를 4이상 입력했을 때, cars의 car가 움직이는지 테스트")
  @Test
  void moveCars_success() {
    //given
    int carNumber = 1;
    int randomNumber = (int) (Math.random() * 10 + 4);
    Cars cars = makeCars(carNumber, randomNumber);
    Car car = new Car(1);

    // when
    cars.move();

    // then
    Car movedCar = cars.getCars().get(0);
    assertThat(movedCar).isEqualTo(car);
  }

  @DisplayName("랜덤 숫자를 4미만 입력했을 때, cars의 car가 움직이는지 않는지 테스트")
  @Test
  void moveCars_fail() {
    //given
    int carNumber = 1;
    int randomNumber = (int) (Math.random() + 3);
    Cars cars = makeCars(carNumber, randomNumber);
    Car car = new Car(0);

    // when
    cars.move();

    // then
    Car movedCar = cars.getCars().get(0);
    assertThat(movedCar).isEqualTo(car);
  }

}
