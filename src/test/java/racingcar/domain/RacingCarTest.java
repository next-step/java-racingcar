package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ValueSource(strings = {"yang", "woo", "park"})
    @ParameterizedTest
    void 자동차는_이름을_가질_수_있다(String name) {
        RacingCar racingCar = new RacingCar(name);
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @ValueSource(strings = {"yangwoo", "watermelone", "smoker"})
    @ParameterizedTest
    void 자동차이름은_5글자가_넘으면_예외가_발생한다(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar(name);
            });
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 자동차의_이름은_빈값이_될_수_없다(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar(name);
            });
    }

    @ValueSource(strings = {"yang", "woo", "lip"})
    @ParameterizedTest
    void 자동차의_초기위치는_0이다(String name) {
        RacingCar racingCar = new RacingCar(name);
        assertThat(racingCar.getPosition()).isZero();
    }

    @Test
    void 사_이상이면_전진한다() {
        final RacingCar racingCar = new RacingCar("yang");
        final RacingCar actual = racingCar.moveForward(() -> true);
        assertThat(actual.getPosition()).isEqualTo(1);
    }

   @Test
    void 사_미만이면_정지한다() {
        RacingCar racingCar = new RacingCar("yang");
        final RacingCar actual = racingCar.moveForward(() -> false);
        assertThat(actual.getPosition()).isEqualTo(0);
    }

}
