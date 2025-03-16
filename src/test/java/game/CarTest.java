package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest(name = "입력값이 {0} 이면 이동하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void move_1(int number) {
        Car car = new Car();
        car.move(number);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "입력값이 {0} 이면 1칸 이동한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_2(int number) {
        Car car = new Car();
        car.move(number);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

}
