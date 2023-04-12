package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarTest {

    @Test
    void 자동차의_초기_위치값은_0이다() {
        Car car = new Car();

        int location = car.location();

        Assertions.assertThat(location).isZero();
    }

}