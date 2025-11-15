package racingGame.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingGame.business.CarFactory.createCars;

import org.junit.jupiter.api.Test;
import racingGame.model.NonNegativeReadyCars;

class CarFactoryTest {


    @Test
    void carMakeTest() {
        String[] strings = {"pobi", "crong","honux"};
        assertThat(createCars(new NonNegativeReadyCars(strings))).hasSize(strings.length);
    }

}