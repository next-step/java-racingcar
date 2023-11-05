package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    public static final int MOVABLE_NUMBER = 4;
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = List.of(
            new Car(new CarName("pobi"), new MovingValidator(new TestMovingStrategy(
                MOVABLE_NUMBER))));
        cars = new Cars(carList);
    }

    @Test
    void 자동차들의_숫자를_알_수_있다() {
        int actual = cars.size();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차들이_움직인다() {
        List<Car> carList = List.of(
            new Car(new CarName("pobi"), new Distance(1),
                new MovingValidator(new TestMovingStrategy(
                    MOVABLE_NUMBER))));
        cars.move();

        Cars actual = this.cars;
        Cars expected = new Cars(carList);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차의_이동거리를_알_수_있다() {
        List<Distance> actual = cars.movingDistances();
        List<Distance> expected = List.of(new Distance());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차의_요소를_추출_할_수_있다() {
        Car actual = cars.get(0);
        Car expected = new Car(new CarName("pobi"),
            new MovingValidator(new TestMovingStrategy(MOVABLE_NUMBER)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차의_모든_요소를_추출_할_수_있다() {
        List<Car> actual = List.of(
            new Car(new CarName("pobi"), new MovingValidator(new TestMovingStrategy(
                MOVABLE_NUMBER))));
        List<Car> expected = cars.getAll();

        assertThat(actual).isEqualTo(expected);
    }

}