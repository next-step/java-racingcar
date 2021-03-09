package study.racing;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingTest {

  @Test
  void createCar() {
    Car car = new Car(4);
    assertEquals(car.getNumbers().size(), 4);
  }

  @Test
  void car_moveCheck() {
    List<Integer> numbers = Arrays.asList(1, 4, 2, 6);
    Car car = new Car(numbers);
    assertAll(
        () -> assertEquals(car.checkMove(0), false),
        () -> assertEquals(car.checkMove(1), true),
        () -> assertEquals(car.checkMove(2), false),
        () -> assertEquals(car.checkMove(3), true),
        () -> assertEquals(car.getMoveCount(), 2)
    );


  }
}