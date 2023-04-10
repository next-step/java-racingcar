package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarMoveControllerTest {

  @Test
  void 자동차_객체에게_움직여라_명령() {
    CarMoveCondition carMoveCondition = new CarMoveCondition();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    CarMoveController carMoveController = new CarMoveController(carMoveCondition, randomNumberGenerator);

    Car car = new Car();
    carMoveController.move(car);

    assertThat(car.position()).isBetween(0, 1);
  }
}