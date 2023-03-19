package racingcar_tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar_tdd.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @DisplayName("자동차는 이름을 가진다.")
    @ValueSource(strings = {"Jason", "박재성"})
    @ParameterizedTest
    public void name(final String name) {
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    public void name() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("동해물과백두산이"));
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    void default_position() {
        final Car car = new Car("jason");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    void current_position() {
        final Car car = new Car("jason", 10);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @DisplayName("자동차가 4상이상일 경우 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void move(final int condition) {
        final Car car = new Car("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 4미만 일 때 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(final int condition) {
        final Car car = new Car("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
