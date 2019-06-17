package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.drivingStrategy.MockDrivingStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    this.car = new Car(1);
    this.car.setDrivingStrategy(MockDrivingStrategy.getInstance());
  }

  @Test
  @DisplayName("InitialPosition은 1이다")
  void initialPosition() {

    assertThat(car.getInitialPosition()).isEqualTo(1);

  }

  @Test
  @DisplayName("move() 메소드")
  void move() {

    assertThat(car.getPosition()).isEqualTo(1);

    car.move();
    assertThat(car.getPosition()).isEqualTo(2);

    car.move();
    assertThat(car.getPosition()).isEqualTo(3);

    car.move();
    assertThat(car.getPosition()).isEqualTo(4);

  }

  @Test
  @DisplayName("reset() 메소드")
  void reset() {

    assertThat(car.getPosition()).isEqualTo(1);

    car.move();
    assertThat(car.getPosition()).isEqualTo(2);

    car.resetPosition();
    assertThat(car.getPosition()).isEqualTo(1);
  }
}

