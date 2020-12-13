package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;

import java.util.Vector;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 최대_이동_자동차_값() {
        String[] carNameArr = {"a","b","c"};
        Cars cars = new Cars(carNameArr);

        IntStream.range(0, 3).forEach(i -> cars.getCars().forEach(car -> car.move(() -> true)));
        assertThat(cars.getMaxLocation()).isEqualTo(4);
    }

    @Test
    void 우승_자동차_이름() {
        String[] carNameArr = {"a","b","c"};
        Cars cars = new Cars(carNameArr);

        IntStream.range(0, 3).forEach(i -> cars.getCars().forEach(car -> car.move(() -> true)));
        assertThat(cars.getWinnerCarNames()).isEqualTo("a, b, c");
    }
}