package edu.nextstep.camp.racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingResultTest {

    @Test
    void toString_테스트 () {
        List<Car> cars = List.of(new Car("test1"), new Car("test2"), new Car("test3"));

        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(3+i);
        }

        RacingResult racingResult = new RacingResult(cars);

        String result = racingResult.toString();

        Assertions.assertThat(result).isEqualTo("test1 : \ntest2 : -\ntest3 : -");
    }
}
