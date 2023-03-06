package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    @DisplayName("자동차는 이름을 가진다")
    @ParameterizedTest
    @ValueSource(strings = {"irene", "jason"})
    void name (final String name) {
//        var car = new Car("irene", 0);
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    void name() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car ("어쩌구저쩌구저쩌구"));
    }

    @DisplayName("자동차의 초기위치는 0이다.")
    @Test
    void default_position() {
        final Car car = new Car("irene");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알수 있다.")
    @Test
    void current_position() {
        final Car car = new Car("irene", 10);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @DisplayName("자동차가 4 이상일 때 이동(전진)한다.")
    @ValueSource(ints = {4, 5, 6, 7})
    @ParameterizedTest
    void move(final int condition) {
        final Car car = new Car("irene");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 4 미만일 때 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void stop(final int condition) {
        final Car car = new Car("irene");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
