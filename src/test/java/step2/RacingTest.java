package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(new String[]{"car1", "car2", "car3"}, 5);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "car1, car2, car3:5",
            "bus1, bus2, bus3, bus4, bus5:5"
    }, delimiter = ':')
    void setRacingTest(String answer, int turn) {
        String[] carsName = answer.trim().split(",");
        racing = new Racing(carsName, turn);
        assertThat(racing.getTurn()).isEqualTo(turn);
    }

    @Test
    void race() {
        racing.race(1);
        assertAll(
                () -> assertEquals(true, racing.getCar(0).getMoveOfTurn(1)),
                () -> assertEquals(true, racing.getCar(1).getMoveOfTurn(1)),
                () -> assertEquals(true, racing.getCar(2).getMoveOfTurn(1))
        );
    }

    @Test
    void moveTest() {
        Car car = racing.getCar(0);
        racing.move(car, 1);
        racing.move(car, 2);
        racing.move(car, 4);
        assertAll(
                () -> assertEquals(false, car.getMoveOfTurn(0)),
                () -> assertEquals(true, car.getMoveOfTurn(1)),
                () -> assertEquals(true, car.getMoveOfTurn(2)),
                () -> assertEquals(false, car.getMoveOfTurn(3)),
                () -> assertEquals(true, car.getMoveOfTurn(4))
        );
    }

}