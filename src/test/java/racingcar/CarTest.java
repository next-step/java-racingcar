package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("차가 움직이면 위치가 증가한다")
    void move() {
        Car car = new Car();

        car.move();

        assertThat(car.getPosition()).isEqualTo("-");
    }

    @ParameterizedTest
    @DisplayName("자동차는 여러번 움직일 수 있다")
    @CsvSource(value = {"2:--", "5:-----"}, delimiter = ':')
    void multiple_move(int moveCount, String position) {
        Car car = new Car();
        for (int count = 0; count < moveCount; count++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(position);
    }


}