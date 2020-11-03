package humbledude.carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    Car car1;
    Car car2;
    Car car3;
    List<Car> cars;
    @BeforeEach
    public void setUp() {
        car1 = new Car();
        car2 = new Car();
        car3 = new Car();
        cars = Arrays.asList(car1, car2, car3);
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

    @Test
    public void getWinners_oneWinner() {
        car1.accelerate(9);
        CarRacing carRacing = new CarRacing(cars, new ConstantFuelGenerator(1));

        assertThat(carRacing.getWinners()).containsExactly(car1);
    }

    @Test
    public void getWinners_twoWinners() {
        car1.accelerate(9);
        car2.accelerate(9);
        CarRacing carRacing = new CarRacing(cars, new ConstantFuelGenerator(1));

        assertThat(carRacing.getWinners()).containsExactly(car1, car2);
    }
}
