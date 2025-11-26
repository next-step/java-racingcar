package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 이름을 부여할 수 있다")
    void assignCarNames() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 빈 문자열이나 null이 될 수 없다")
    void carNameCannotBeNullOrEmpty(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde1", "123456"})
    @DisplayName("각 자동차의 이름은 5자를 초과할 수 없다")
    void carNameCannotExceedFiveCharacters(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이다")
    void returnZero_WhenInitialized() {
        Car car = new Car("test");

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차는 허용된 범위 중에서 4 이상인 수를 받으면 전진한다")
    void moveForward_WhenNumberIsFourOrMore(int number) {
        Car car = new Car("test");

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차는 허용된 범위 중에서 4 미만인 수를 받으면 멈춘다")
    void doNotMove_WhenNumberIsLessThanFour(int number) {
        Car car = new Car("test");

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 여러 번 전진하면 전진한 횟수만큼 위치가 증가한다")
    void addPosition_WhenMovedMultipleTimes() {
        Car car = new Car("test");

        for (int i = 0; i < 5; i++) {
            car.move(4);
        }

        assertThat(car.getPosition()).isEqualTo(5);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 100})
    @DisplayName("입력 값이 허용된 수가 아닐 경우 IllegalArgumentException 예외를 발생시킨다")
    void throwException_WhenNumberIsOutOfRange(int number) {
        Car car = new Car("test");

        assertThatThrownBy(() -> car.move(number)).isInstanceOf(IllegalArgumentException.class);

    }
}
