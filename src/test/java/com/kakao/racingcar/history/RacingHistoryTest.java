package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.Car;
import com.kakao.racingcar.domain.CarCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingHistoryTest {

    @Test
    @DisplayName("racingHistory 로깅 기능을 이용하여, 차의 이동 기록을 저장한다.")
    void logging() {
        Car car = new Car(0);
        RacingHistory racingHistory = new RacingHistory();

        moveAndRecordCar(car, racingHistory);

        Map<Integer, List<CarHistory>> result = racingHistory.getResult();
        List<CarHistory> round1 = result.get(1);
        assertThat(round1.get(0).getPosition()).isEqualTo(1);
        List<CarHistory> round2 = result.get(2);
        assertThat(round2.get(0).getPosition()).isEqualTo(2);
        List<CarHistory> round3 = result.get(3);
        assertThat(round3.get(0).getPosition()).isEqualTo(2);
    }

    private void moveAndRecordCar(Car car, RacingHistory racingHistory) {
        car.tryMove(10);
        racingHistory.logging(1, Collections.singletonList(car));
        car.tryMove(10);
        racingHistory.logging(2, Collections.singletonList(car));
        car.tryMove(0);
        racingHistory.logging(3, Collections.singletonList(car));
    }

}
