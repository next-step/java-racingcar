package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("처음 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car("pobi");

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("값이 4 이상이면 위치가 1 증가한다")
    void moveForwardIfNumberIsFourOrMore(int number) {
        Car car = new Car("pobi");

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("값이 3 이하면 위치가 그대로다")
    void stayIfNumberIsThreeOrLess(int number) {
        Car car = new Car("pobi");

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong"})
    @DisplayName("차는 이름을 가진다")
    void containsName(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", ""})
    @DisplayName("차의 이름은 null 이거나 비어있거나 공란으로만 이루어져 있으면 IllegalArgumentException")
    void throwsExceptionWhenEmptyOrBlank(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name))
                .withMessage("valid name is required [" + name + "]");
    }

    @Test
    @DisplayName("차의 이름은 5자를 초과할 수 없다, 초과하면 IllegalArgumentException")
    void throwsExceptionWhenExceeds5Characters() {
        String name = "abcdef";

        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name))
                .withMessage("too long for name [" + name + "]");
    }
}
