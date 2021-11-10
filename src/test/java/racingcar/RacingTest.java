package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    void 승자_한명() {
        Car kang = new Car("kang",4);
        Car chang = new Car("chang",2);
        Car mo = new Car("mo",3);

        Racing racing = new Racing(5, kang, chang, mo);
        List<Car> winners = racing.winners();
        assertThat(winners).contains(kang);
    }

    @Test
    void 승자_두명이상() {
        Car kang = new Car("kang",4);
        Car chang = new Car("chang",3);
        Car mo = new Car("mo",4);

        Racing racing = new Racing(5, kang, chang, mo);
        List<Car> winners = racing.winners();
        assertThat(winners).contains(kang, mo);
    }
}
