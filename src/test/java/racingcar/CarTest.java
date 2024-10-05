package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 수 없다.")
    void name() {
        assertThatThrownBy(() -> new Car("newcar"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("자동차는 MoveStrategy에 따라 움직인다.")
    void move_forward(int input, int expected) {
        Car car = new Car("hoya");
        car.move(new FourOrMore(new TestRandomHolder(input)));
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
