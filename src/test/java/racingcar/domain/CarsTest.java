package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.FixedEngine;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    void 참가자_생성_테스트() {
        Cars cars = new Cars(new String[]{"pobi"}, new FixedEngine(true));
        assertThat(cars.cars()
            .get(0)
            .name()).isEqualTo(new Name("pobi"));
    }

    @Test
    void 참가자_생성_예외_테스트() {
        assertThatThrownBy(() -> new Cars(new String[]{"jasons"}, new FixedEngine(false)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_움직임_테스트() {
        Cars cars = new Cars(new String[]{"pobi"}, new FixedEngine(true));
        cars.moveAll();
        assertThat(cars.cars().get(0).position()).isEqualTo(1);
    }
}
