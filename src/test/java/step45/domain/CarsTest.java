package step45.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  void getWinnerTest() {
    //given
    Car car1 = new Car("car1");
    car1.move(5);
    Car car2 = new Car("car2");
    car2.move(5);
    Car car3 = new Car("car3");
    car3.move(3);

    Cars cars = new Cars(Arrays.asList(car1, car2, car3));

    //when
    List<Car> winners = cars.getWinners();

    //then
    assertThat(winners).contains(car1, car2);
  }
}