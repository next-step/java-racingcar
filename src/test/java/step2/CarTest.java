package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private static Car car = new Car(5);

    @ParameterizedTest
    @CsvSource(value = {"true:1:1", "true:2:2", "false:3:2", "true:4:3", "false:5:3"}, delimiter = ':')
    void go(boolean is, int turn, int score) {
        if (is) {
            car.go(turn);
        }
        assertThat(car.getScore(turn)).isEqualTo(score);
    }


    @Test
    void getScoreTest() {
        Car car = new Car(5);
        car.moveCountSet.set(1);
        car.moveCountSet.set(2);
        car.moveCountSet.set(4);
        assertAll(
                () -> assertEquals(0, car.getScore(1)),
                () -> assertEquals(1, car.getScore(2)),
                () -> assertEquals(2, car.getScore(3)),
                () -> assertEquals(2, car.getScore(4)),
                () -> assertEquals(3, car.getScore(5))
        );
    }
}