package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.CarCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RoundHistoryTest {

    @Test
    @DisplayName("해당 라운드의 모든 차들의 위치를 기록한다.")
    void carHistoryPosition() {
        CarCollection carCollection = new CarCollection(Arrays.asList("jyami", "mj"));
        RoundHistory roundHistory = new RoundHistory(1, carCollection.tryMoveCars(Arrays.asList(10, 0)));

        assertThat(roundHistory.getCarHistories())
                .extracting(CarHistory::getPosition).containsExactly(1, 0);
    }

    @Test
    @DisplayName("해당 라운드의 모든 차들의 정보를 기록한다.")
    void carHistoryInfo() {
        CarCollection carCollection = new CarCollection(Arrays.asList("jyami", "mj"));
        RoundHistory roundHistory = new RoundHistory(1, carCollection.tryMoveCars(Arrays.asList(10, 0)));

        assertThat(roundHistory.getCarHistories())
                .containsExactly(new CarHistory(1, "jyami"), new CarHistory(0, "mj"));
    }
}
