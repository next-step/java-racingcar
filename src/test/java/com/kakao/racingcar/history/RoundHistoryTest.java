package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundHistoryTest {

    @Test
    @DisplayName("해당 라운드의 모든 차들의 위치를 기록한다.")
    void of() {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.tryMove(10);
        List<Car> cars = Arrays.asList(car1, car2);
        RoundHistory roundHistory = RoundHistory.of(1, cars);
        List<CarHistory> carHistories = roundHistory.getCarHistories();
        assertThat(carHistories.get(0).getPosition()).isEqualTo(car1.getPosition());
        assertThat(carHistories.get(1).getPosition()).isEqualTo(car2.getPosition());
    }
}
