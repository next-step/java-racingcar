package racingGame.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingGame.business.CarFactory.createCars;

import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    void carSetTest() {
        String[] strings = {};
        assertThatThrownBy(() -> {
            createCars(strings);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s", "참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    @Test
    void carMakeTest() {
        String[] strings = {"pobi", "crong","honux"};
        assertThat(createCars(strings)).hasSize(strings.length);
    }

}