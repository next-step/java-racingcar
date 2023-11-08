package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = List.of(
            new Car(new CarName("pobi")));
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
            new Car(new CarName("pobi"), new Distance(1)));
        cars.move(0);

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
    void 자동차들을_생성_할_수_있다() {
        boolean actual = cars.contain(Cars.from(new String[]{"pobi"}));

        assertThat(actual).isTrue();
    }

    @Test
    void 자동차의_모든_요소를_추출_할_수_있다() {
        List<Car> actual = List.of(
            new Car(new CarName("pobi")));
        List<Car> expected = cars.findAll();

        assertThat(actual).isEqualTo(expected);
    }

}