package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
  static class CarSuccessTest {
    Car car;

    @BeforeEach
    void setUp() {
      car = new Car(new RacingCarMovingStrategy() {
        @Override
        public boolean isCanMove() {
          return true;
        }
      });
    }

    @Test
    void testGetDistance() {
      assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void testMove() {
      car.move();
      assertThat(car.getDistance()).isEqualTo(1);
    }
  }
  static class CarFailureTest {
    Car car;

    @BeforeEach
    void setUp() {
      car = new Car(new RacingCarMovingStrategy() {
        @Override
        public boolean isCanMove() {
          return false;
        }
      });
    }

    @Test
    void testMove() {
      car.move();
      assertThat(car.getDistance()).isNotEqualTo(1);
      assertThat(car.getDistance()).isEqualTo(0);
    }
  }

}
