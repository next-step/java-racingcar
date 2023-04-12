package racingcar.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.service.Car.moveIfOver4;
import static racingcar.service.Car.race;
import static racingcar.service.Car.move;
import static racingcar.service.Car.stop;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    void 숫자4이상이_나오면_전진(int number, boolean expected) {
        assertThat(moveIfOver4(number)).isEqualTo(expected);
    }

    @Test
    void 레이스() {
        assertThat(race(3)).hasSize(3);
    }

    @Test
    void 움직인다() {
        assertThat(move(3)).isEqualTo(4);
    }

    @Test
    void 멈춘다() {
        assertThat(stop(3)).isEqualTo(3);
    }

    @Test
    void 이름() {
        Car test = new Car("테스트", race(3));
        assertThat(test.getName()).isEqualTo("테스트");

        Car test2 = new Car("테스트2");
        assertThat(test2.getName()).isEqualTo("테스트2");
    }

}
