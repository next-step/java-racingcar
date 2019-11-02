package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    private static Car car = new Car("bus", 5);

    @ParameterizedTest
    @CsvSource(value = {"0:true:-", "1:true:--", "2:false:--", "3:true:---", "4:false:---"}, delimiter = ':')
    void go(int turn, boolean is, String graph) {
        if (is) {
            car.go(turn);
        }
        assertThat(car.getStringScore(turn)).isEqualTo(graph);
    }


    @Test
    void getStringScore() {
        Car car = new Car("bus", 6);
        car.go(1);
        car.go(2);
        car.go(4);
        assertAll(
                () -> assertThat(car.getStringScore(0)).isEqualTo(""),
                () -> assertThat(car.getStringScore(1)).isEqualTo("-"),
                () -> assertThat(car.getStringScore(2)).isEqualTo("--"),
                () -> assertThat(car.getStringScore(3)).isEqualTo("--"),
                () -> assertThat(car.getStringScore(4)).isEqualTo("---")
        );

    }
}