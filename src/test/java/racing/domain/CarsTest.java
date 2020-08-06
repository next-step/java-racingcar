package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final String[] names = {"pobi","crong","honux"};

    @Test
    void 자동차_개수() {
        Cars cars = new Cars(String.join(",", names));
        assertThat(cars.getCarCount()).isEqualTo(3);
    }

    @Test
    void 자동차_이름() {
        Cars cars = new Cars(String.join(",", names));
        assertThat(cars.getCarNames()).isEqualTo(names);
    }

    @Test
    void 가장_많이_이동한_차_이름() {
        // given
        Cars cars = new Cars(String.join(",", names));

        // when
        cars.moveCars((carName, distance) -> {});

        // then
        int maxDistance = Collections.max(cars.getCars(), Comparator.comparingInt(Car::getDistance))
                .getDistance();
        String[] names = cars.getCars()
                .stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toArray(String[]::new);

        assertThat(cars.getMaxMovedCarNames()).isEqualTo(names);
    }

    @Test
    void 랜덤_범위_확인() {
        Cars cars = new Cars(String.join(",", names));
        for (int i = 0; i < 10; i++) {
            int randomNumber = cars.getRandomNumber();
            assertThat(randomNumber)
                    .isBetween(CarRacingProperty.MIN_RANDOM_NUMBER, CarRacingProperty.MAX_RANDOM_NUMBER);
        }
    }
}
