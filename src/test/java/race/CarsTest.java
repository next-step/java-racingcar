package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.model.TestCars;
import racing.model.Car;
import racing.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    TestCars testCars = new TestCars();

    @BeforeEach
    void setting() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1", 1));
        testCars.add(new Car("test2", 3));
        testCars.add(new Car("test3", 2));
        this.testCars.prepareCars(testCars);
    }

    @Test
    @DisplayName("cars max Distance Test")
    void carsMaxDistanceTest() {
        assertThat(testCars.getMaxDistance()).isEqualTo(3);
    }


    @Test
    @DisplayName("winner test")
    void winnerTest() {
        assertThat(testCars.findWinners().get(0).carName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("more than one winner test")
    void moreThanOneWinnerTest() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1", 30));
        testCars.add(new Car("test2", 30));
        testCars.add(new Car("test3", 30));
        this.testCars.prepareCars(testCars);
        Assertions.assertThat(this.testCars.findWinners().stream())
                .extracting(Car::carName)
                .containsExactly("test1", "test2", "test3");
    }

    @Test
    @DisplayName("more than one winner test")
    void carsMoveTest(){
        this.testCars.carsMove(() -> true);
        assertThat(this.testCars.getMaxDistance()).isEqualTo(4);
    }


}
