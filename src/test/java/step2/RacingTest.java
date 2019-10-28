package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    InputView inputView = new InputView();
    Racing racing;
    @BeforeEach
    void setUp() {
        inputView = new InputView();
        inputView.carNum = 3;
        inputView.turn = 5;
        racing = new Racing(inputView);
    }

    @ParameterizedTest
    @CsvSource(value={
            "3:5",
            "5:5"
    }, delimiter = ':')
    void setRacingTest(int carNum, int turn) {
        inputView.carNum = carNum;
        inputView.turn = turn;
        racing = new Racing(inputView);
        assertThat(racing.cars.length).isEqualTo(carNum);
        assertThat(racing.turn).isEqualTo(turn);
    }

    @Test
    void race() {
        racing.race(1);
        assertAll(
                () -> assertEquals(1, racing.cars[0].getScore(1)),
                () -> assertEquals(1, racing.cars[0].getScore(1)),
                () -> assertEquals(1, racing.cars[0].getScore(1)),
                () -> assertEquals(1, racing.cars[0].getScore(1)),
                () -> assertEquals(1, racing.cars[0].getScore(1))
        );
    }

    @Test
    void moveTest() {
        Car car = racing.cars[0];
        racing.move(car, 1);
        racing.move(car, 2);
        racing.move(car, 4);

        assertAll(
                () -> assertEquals(1, car.getScore(1)),
                () -> assertEquals(2, car.getScore(2)),
                () -> assertEquals(2, car.getScore(3)),
                () -> assertEquals(3, car.getScore(4)),
                () -> assertEquals(3, car.getScore(5))
        );
    }

}