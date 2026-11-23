package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private static final CarName POBI = new CarName("pobi");

    @Test
    @DisplayName("이름과 위치를 가진다")
    void hasNameAndPosition() {
        Car car = new Car(POBI, 3);

        assertThat(car.getName()).isEqualTo(POBI);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("이름만으로 생성하면 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car(POBI);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 null이면 IllegalArgumentException")
    void throwsExceptionWhenNameIsNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null))
                .withMessage("car name is required");
    }

    @Test
    @DisplayName("위치가 음수면 IllegalArgumentException")
    void throwsExceptionWhenPositionIsNegative() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(POBI, -1))
                .withMessage("position can not be negative value [-1]");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("숫자가 4 이상이면 위치가 1 증가한다")
    void moveForwardIfNumberIsFourOrMore(int number) {
        Car car = new Car(POBI);

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("숫자가 3 이하면 위치가 그대로다")
    void stayIfNumberIsThreeOrLess(int number) {
        Car car = new Car(POBI);

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
