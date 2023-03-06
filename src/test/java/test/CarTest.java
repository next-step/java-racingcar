package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.Car;

public class CarTest {
    @DisplayName("자동차는 이름을 가진다")
    @ValueSource(strings = {"jason", "박재성"})
    @ParameterizedTest
    public void name(final String name) {
        final Car2 car = new Car2(name);
        assertThat(car.getName()).isEqualTo(name);
    }
    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    public void name() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car2("동해물과 백두산이"));
    }
    @DisplayName("자동차의 초기 위치는 0이다.")
    @Test
    public void default_position() {
        final Car2 car = new Car2("jason");
        assertThat(car.getPosition()).isZero();
    }
    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    public void current_position() {
        final Car2 car = new Car2("jason",10);
        assertThat(car.getPosition()).isEqualTo(10);
    }
    @DisplayName("자동차가 4 이상일 때 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    public void move(final int condition) {
        final Car2 car = new Car2("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @DisplayName("자동차가 4 미만일 때 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void stop(final int condition) {
        final Car2 car = new Car2("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
