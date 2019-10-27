package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static Car car = new Car(5);

    @ParameterizedTest
    @CsvSource(value = {"true:1:1", "true:2:2", "false:3:2", "true:4:3", "false:5:3"}, delimiter = ':')
    void go(boolean is, int turn, int score) {
        if (is) {
            car.ahead(turn);
        }
        assertThat(car.getScore(turn)).isEqualTo(score);
    }


    @Test
    void getScoreTest() {
        Car car = new Car(5);
        car.moveCountSet.set(1);
        car.moveCountSet.set(2);
        car.moveCountSet.set(4);
        assertThat(car.getScore(1)).isEqualTo(0);
        assertThat(car.getScore(2)).isEqualTo(1);
        assertThat(car.getScore(3)).isEqualTo(2);
        assertThat(car.getScore(4)).isEqualTo(2);
        assertThat(car.getScore(5)).isEqualTo(3);
    }
}