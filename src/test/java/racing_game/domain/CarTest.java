package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import javax.management.relation.RelationNotFoundException;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void create() {
    Moving moving = new RandomMoving(10, 4);
    Car car = Car.create(moving);
    assertThat(car).isNotNull();
  }

  @Test
  void move() {
    Moving moving = new RandomMoving(10, 0);
    Car car = Car.create(moving);
    car.move();
    int distance = car.getDistance().toInt();
    assertThat(distance).isEqualTo(1);
  }
}
