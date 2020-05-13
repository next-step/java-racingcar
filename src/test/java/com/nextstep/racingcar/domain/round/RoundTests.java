package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import com.nextstep.racingcar.domain.car.Cars;
import com.nextstep.racingcar.domain.car.ForceMoveStrategy;
import com.nextstep.racingcar.domain.car.MoveLength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTests {
    private Cars cars;

    @BeforeEach
    public void setup() {
        cars = Cars.create(Arrays.asList(new Car(), new Car()));
    }

    @DisplayName("차량들을 입력받아 Round에서 진행할 차량들을 등록한다.")
    @Test
    void createRoundTest() {
        Round round = Round.newRound(cars);

        assertThat(round.getCarNumber()).isEqualTo(2);
    }

    @DisplayName("모든 차량을 1회씩 출발시킨다.")
    @Test
    void moveAllCar() {
        Round round = Round.newRound(cars);

        List<MoveLength> beforeResult = round.getResult();
        assertThat(beforeResult.get(0).toInt()).isEqualTo(0);
        assertThat(beforeResult.get(1).toInt()).isEqualTo(0);

        round.moveAll(new ForceMoveStrategy());

        List<MoveLength> afterResult = round.getResult();
        assertThat(afterResult.get(0).toInt()).isEqualTo(1);
        assertThat(afterResult.get(1).toInt()).isEqualTo(1);
    }

    @DisplayName("String으로 된 통합 결과를 확인한다.")
    @Test
    void checkStringResult() {
        Round round = Round.newRound(cars);
        round.moveAll(new ForceMoveStrategy());

        String totalResult = round.getTotalResult();

        assertThat(totalResult).isEqualTo("-\n-\n");
    }
}
