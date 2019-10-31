package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static Car car = new Car("bus", 5);

    @ParameterizedTest
    @CsvSource(value = {"true:0", "true:1", "false:2", "true:3", "false:4"}, delimiter = ':')
    void go(boolean is, int turn) {
        if (is) {
            car.go(turn);
        }
        assertThat(car.getMoveOfTurn(turn)).isEqualTo(is);
    }


    @Test
    void getMove() {
        Car car = new Car("bus", 6);
        car.go(2);
        car.go(3);
        car.go(5);
        assertAll(
                () -> assertFalse(car.getMoveOfTurn(0)),
                () -> assertFalse(car.getMoveOfTurn(1)),
                () -> assertTrue(car.getMoveOfTurn(2)),
                () -> assertTrue(car.getMoveOfTurn(3)),
                () -> assertFalse(car.getMoveOfTurn(4)),
                () -> assertTrue(car.getMoveOfTurn(5))
        );

    }
}