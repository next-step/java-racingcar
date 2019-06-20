package study.racingcar.domain;

import org.junit.jupiter.api.Test;
import study.racingcar.strategy.ManualMovableStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class CarsTest {
    @Test
    void Cars_생성() {
        List<String> carNames = Arrays.asList("pobi", "crong");
        Cars cars = new Cars(new HashSet(carNames));
        assertThat(cars.getCars()).size().isEqualTo(carNames.size());
    }

    @Test
    void Cars_중복이름_생성() {
        List<String> carNames = Arrays.asList("pobi", "pobi");
        Cars cars = new Cars(new HashSet(carNames));
        assertThat(cars.getCars()).size().isEqualTo(1);
    }

    @Test
    void allRun() {
        List<String> carNames = Arrays.asList("pobi", "crong");
        Cars cars = new Cars(new HashSet(carNames), new ManualMovableStrategy(true));
        cars.allRun();

        cars.getCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(2);
        });
    }
}