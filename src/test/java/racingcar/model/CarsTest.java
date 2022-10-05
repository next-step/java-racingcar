package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.nickname.Nickname;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final List<Car> readyCars = new ArrayList<>();
    private final List<String> names = new ArrayList<>();

    @BeforeEach
    void setUp() {
        names.add("apple");
        names.add("boost");
        names.add("jung");

        names.forEach(name -> readyCars.add(new Car(name)));
    }

    @Test
    void of() {
        Cars expected = new Cars(readyCars);
        Cars actual = Cars.of(names);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void move() {
        List<Car> expected = new ArrayList<>();
        names.forEach(name -> expected.add(createCar(name, 1)));

        Cars cars = Cars.of(names);
        List<Car> actual = cars.move(new SuccessCondition());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinner() {
        List<Car> expected = new ArrayList<>();
        expected.add(createCar(names.get(2), 3));

        List<Car> movedCars = new ArrayList<>();
        movedCars.add(createCar(names.get(0), 1));
        movedCars.add(createCar(names.get(1), 2));
        movedCars.add(createCar(names.get(2), 3));

        Cars cars = new Cars(movedCars);
        List<Car> actual = cars.getWinners();

        assertThat(actual).isEqualTo(expected);
    }

    private Car createCar(String name, int position) {
        return new Car(new Nickname(name), new Position(position));
    }
}
