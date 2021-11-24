package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("when create car, default status are set - position equals to 0")
    void createCar() {
        // given
        Name name = new Name("");
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("when create car with name, default position and name is set")
    void createCarWithName() {
        // given
        // when
        Car car = new Car(new Name("Dodi"));
        Name expectedName = new Name("Dodi");
        // then
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Move car with test strategy - position becomes plus 1")
    void moveCar() {
        // given
        Name name = new Name("");
        Car car = new Car(name);

        // when
        car.move(() -> true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("No move car with test strategy - position becomes the same as before")
    void stopCar() {
        // given
        Name name = new Name("");
        Car car = new Car(name);

        // when
        car.move(() -> false);


        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
