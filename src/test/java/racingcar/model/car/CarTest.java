package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 0, 1, 2, 3})
    @DisplayName("자동차는 지정한 만큼 움직인다")
    public void move(int movement) {
        Car car = new Car("test", () -> movement);
        car.move();

        Distance distance = car.distance();
        assertThat(distance).isEqualTo(new Distance(movement));
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 나야한다")
    public void nameLength() {
        String name = "123456";

        Assertions.assertThatThrownBy(() -> new Car(name, () -> 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 없거나 null이면 예외가 나야 한다")
    public void emptyName(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name, () -> 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}