package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {
    @Test
    void Referee는_1등을_판별할_수_있다() {
        List<CarInformation> cars = new ArrayList<>();
        cars.add(new CarInformation("A", Position.valueOf(5)));
        cars.add(new CarInformation("B", Position.valueOf(3)));
        cars.add(new CarInformation("C", Position.valueOf(0)));

        List<CarInformation> winners = Referee.judgeWinners(cars);

        assertThat(winners).containsExactly(cars.get(0));
    }

    @Test
    void 일등은_여러명이_가능하다() {
        List<CarInformation> cars = new ArrayList<>();
        cars.add(new CarInformation("A", Position.valueOf(5)));
        cars.add(new CarInformation("B", Position.valueOf(5)));
        cars.add(new CarInformation("C", Position.valueOf(0)));

        List<CarInformation> winners = Referee.judgeWinners(cars);

        assertThat(winners).containsExactly(cars.get(0), cars.get(1));
    }
}