package step4.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.number.Number;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private final Car car = new Car("Car");

    @ParameterizedTest
    @DisplayName("4<=Number<=9인 경우 자동차는 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void tryMove_Move(int value) {
        Number number = new Number(value);
        car.tryMove(number);
        Position position = car.getPosition();

        assertEquals(new Position(1), position);
    }

    @ParameterizedTest
    @DisplayName("0<=Number<=3인 경우 자동차는 이동하지 않는다")
    @ValueSource(ints = {0, 1, 2, 3})
    void tryMove_Stay(int value) {
        Number number = new Number(value);
        car.tryMove(number);
        Position position = car.getPosition();

        assertEquals(new Position(0), position);
    }
}