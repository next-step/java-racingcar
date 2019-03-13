package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CarTest {

  @Test
  public void test_name() {

    // Given
    String carName = "pobi";

    // When
    Car car = new Car(new TestRandomGenerator(true), carName);

    // Then
    assertThat(car.getName()).isEqualTo(carName);
  }

  @Test
  public void test_move() {

    // Given
    int minNumber = 4;
    Car car = new Car(new TestRandomGenerator(true), "pobi");

    // When
    car.move(minNumber);

    // Then
    assertThat(car.getPosition()).isEqualTo( 1);
  }

  @Test
  public void test_dont_move() {

    // Given
    int minNumber = 4;
    Car car = new Car(new TestRandomGenerator(false), "pobi");

    // When
    car.move(minNumber);

    // Then
    assertThat(car.getPosition()).isEqualTo( 0);
  }
}
