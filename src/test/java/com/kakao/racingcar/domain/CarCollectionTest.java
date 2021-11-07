package com.kakao.racingcar.domain;

import com.kakao.racingcar.history.CarHistory;
import com.kakao.racingcar.history.RacingHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarCollectionTest {
    @Test
    @DisplayName("입력한 숫자만큼의 차 저장소를 생성한다.")
    void carCollectionConstructor() {
        CarCollection carCollection = new CarCollection(6);
        assertThat(carCollection.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 숫자만큼의 차 저장소에서 이동을 완료한 후에, 차의 이동 기록을 볼 수 있다.")
    void carCollectionRacingHistory() {
        CarCollection carCollection = new CarCollection(3);
        int tryMove = 10;
        for (int i = 0; i < tryMove; i++) {
            carCollection.tryMoveCars(0, Arrays.asList(10, 10, 0));
        }
        RacingHistory racingHistory = carCollection.getRacingHistory();
        assertThat(racingHistory.getResult().size()).isEqualTo(tryMove);
    }

}
