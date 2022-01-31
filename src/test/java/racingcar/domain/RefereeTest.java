package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee;

    @Test
    void 가장_멀리_간_자동차를_우승자로_판별하는_테스트() {
        Car dami = new Car("dami");
        Car crong = new Car("crong");
        Car jason = new Car("jason");
        Referee referee = new Referee();

        dami.move(5);
        crong.move(8);
        jason.move(6);

        List<Car> cars = Arrays.asList(dami, crong, jason);

        String result = referee.getWinners(cars);
        String expectedResult = crong.getName();

        assertThat(expectedResult).isEqualTo(result);
    }
}