package humbledude.carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    List<Car> cars;
    @BeforeEach
    public void setUp() {
         cars = Arrays.asList(new Car(), new Car(), new Car());
    }

    @Test
    public void runningCars() {
        CarRacing carRacing = new CarRacing(cars, new ConstantFuelGenerator(9));
        carRacing.playOneTurn();

        assertThat(cars).extracting(Car::getPosition)
                .allSatisfy(x -> assertThat(x).isOne());
    }

    @Test
    public void notRunningCars() {
        CarRacing carRacing = new CarRacing(cars, new ConstantFuelGenerator(1));
        carRacing.playOneTurn();

        assertThat(cars).extracting(Car::getPosition)
                .allSatisfy(x -> assertThat(x).isZero());
    }
}
