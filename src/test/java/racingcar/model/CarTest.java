package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 전진_불가(final int condition) {
        Car car = new Car("leah");
        car.moveForward(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 전진_가능(final int condition) {
        Car car = new Car("leah");
        car.moveForward(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(strings = {"LeahJiin", "Samuel", "JiinLee"})
    @ParameterizedTest
    void 자동차의_이름이_5글자_넘으면_예외_발생(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(name));
    }

    @Test
    void 가장_멀리간_자동차가_5만큼_갔을때_일치하는_자동차_찾기() {
        Car car = new Car("leah", 5);
        int maxPosition = 5;
        assertThat(car.isSamePosition(maxPosition)).isEqualTo(true);
    }

    @Test
    void 현재까지_찾은_맥스_포지션과_비교하기() {
        Car carLeah = new Car("Leah", 3);
        int result = carLeah.compareMaxPosition(2);
        assertThat(result).isEqualTo(3);
    }

}
