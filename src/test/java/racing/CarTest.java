package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;

    @DisplayName("각 자동차에 이름을 부여할 수 있다. ")
    @Test
    void playerCar() {
        car = new Car("chloe");
        assertThat(car.getName()).isEqualTo("chloe");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> {
            car = new Car("bigRigs");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void MoveTest() {
        Car car = new Car("ss");
        Car newCar = new Car("tt");

        car.moved(true);
        newCar.moved(false);

        List<Integer> movedRanges = Arrays.asList(car.getMovingRange(), newCar.getMovingRange());

        assertThat(movedRanges).containsExactly(1, 0);
    }
}
