package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.game.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    @DisplayName("움직임이 4 미만일 경우, 자동차는 움직이지 않아야 한다.")
    void carMoveTest(int number, int expected) {
        Car car = new Car("car1");
        car.move(number);
        assertThat(car.isSamePosition(expected)).isTrue();
    }

    @Test
    @DisplayName("움직임이 9 이상일 경우, IllegalArgumentException이 발생해야 한다.")
    void carMoveExceptionTest() {
        Car car = new Car("car1");
        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("움직일 수 있는 조건을 벗어났습니다. 값 : 10");
    }

    @Test
    @DisplayName("움직임이 0 미만일 경우, IllegalArgumentException이 발생해야 한다.")
    void carMoveExceptionTest2() {
        Car car = new Car("car1");
        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("움직일 수 있는 조건을 벗어났습니다. 값 : -1");
    }

    @Test
    @DisplayName("자동차 이름이 null일 경우, IllegalArgumentException이 발생해야 한다.")
    void carNameNullExceptionTest() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있거나 null이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우, IllegalArgumentException이 발생해야 한다.")
    void carNameEmptyExceptionTest() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있거나 null이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우, IllegalArgumentException이 발생해야 한다.")
    void carNameLengthExceptionTest() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이내일 경우, 정상적으로 생성되어야 한다.")
    void carNameLengthTest() {
        Car car = new Car("hihi");
        assertThat(car.getName()).isEqualTo("hihi");
    }

    @Test
    @DisplayName("자동차 isSamePosition 메서드가 정상적으로 작동하는지 확인한다.")
    void carIsSamePositionTest() {
        Car car = new Car("car1", 1);
        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    @DisplayName("자동차 max 메서드가 정상적으로 작동하는지 확인한다.")
    void carMaxTest() {
        Car car = new Car("car1", 1);
        assertThat(car.max(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 copy 메서드가 정상적으로 작동하는지 확인한다.")
    void carCopyTest() {
        Car car = new Car("car1", 1);
        Car copyCar = car.copy();
        assertThat(copyCar).isNotSameAs(car);
    }
}
