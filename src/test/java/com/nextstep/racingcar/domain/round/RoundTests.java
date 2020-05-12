package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTests {
    @DisplayName("차량들을 입력받아 Round에서 진행할 차량들을 등록한다.")
    @Test
    void createRoundTest() {
        List<Car> cars = Arrays.asList(new ForceMoveCar(), new ForceMoveCar());
        Round round = Round.newRound(cars);
        assertThat(round.getCarNumber()).isEqualTo(2);
    }

    @DisplayName("모든 차량을 1회씩 출발시킨다.")
    @Test
    void moveAllCar() {
        // TODO: 테스트 용이성을 위해 강제로 움직일 수 있는 가짜 차량을 만들고 돌아오자
        List<Car> cars = Arrays.asList(new ForceMoveCar(), new ForceMoveCar());
        Round round = Round.newRound(cars);
        round.moveAll();
    }
}
