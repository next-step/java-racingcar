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

    @ValueSource(ints = {4, 5, 6, 7, 8})
    @ParameterizedTest
    void 사_이상이면_전진한다(int randomNumber) {
        RacingCar car = new RacingCar("yang");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 사_미만이면_정지한다(int randomNumber) {
        RacingCar racingCar = new RacingCar("yang");
        racingCar.moveForward(randomNumber);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    void 모든차는_앞으로_전진한다() {
        List<RacingCar> racingCarList = new ArrayList<>(
            Arrays.asList(new RacingCar("yang"), new RacingCar("woo"), new RacingCar("yu")));
        racingCarList.get(0).moveForward(5);
        racingCarList.get(1).moveForward(3);
        racingCarList.get(2).moveForward(6);

        Assertions.assertThat(racingCarList.get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(racingCarList.get(1).getPosition()).isZero();
        Assertions.assertThat(racingCarList.get(2).getPosition()).isEqualTo(1);
    }
}
