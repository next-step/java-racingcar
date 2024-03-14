package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.generator.IntGenerator;
import racingCar.domain.generator.RandomGenerator;

public class CarTest {

  Car car;
  @BeforeEach
  void setUp() {
    IntGenerator intGenerator = new RandomGenerator();
    car = new Car("hoi", intGenerator);
  }

  @Test
  @DisplayName("차의 처음 위치가 원점인지 확인한다")
  void 차의_처음_위치가_원점인지_확인() {
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("경기를 1회 진행하면 차는 0 또는 1만큼 움직이는지 확인한다")
  void 차가_움직이는지_확인(){
    car.move();
    assertThat(car.getPosition()).isIn(0, 1);
  }

  @Test
  @DisplayName("차 인스턴스를 생성할 때 이름을 지정한다")
  void getCarName(){
    String carName = "hadi";
    Car hadiCar = new Car(carName, new RandomGenerator());

    assertThat(hadiCar.getName()).isEqualTo(carName);
  }
}
