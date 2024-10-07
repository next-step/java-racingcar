package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.mock.TestRandomHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차를 복사하여 반환한다.")
    void copy() {
        Car car = new Car(1, "hoya");
        assertThat(car.copy()).isEqualTo(car);
    }

    @Test
    @DisplayName("자동차의 상태를 출력한다.")
    void print() {
        Car car = new Car(5, "hoya");
        assertThat(car.print()).isEqualTo("hoya : -----");
    }

    @Test
    @DisplayName("자동차의 위치가 같으면 true, 다르면 false 반환")
    void isEqualsPosition() {
        Car car = new Car(0);
        Car samePositionCar = new Car(0);
        Car diffPositionCar = new Car(1);
        assertThat(car.isEqualsPosition(samePositionCar)).isTrue();
        assertThat(car.isEqualsPosition(diffPositionCar)).isFalse();
    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 수 없다.")
    void Car_name() {
        assertThatThrownBy(() -> new Car("newcar"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("자동차는 MoveStrategy에 따라 움직인다.")
    void move_forward(int input, int expected) {
        Car car = new Car();
        car.move(new FourOrMore(new TestRandomHolder(input)));
        assertThat(car).isEqualTo(new Car(expected));
    }
}
