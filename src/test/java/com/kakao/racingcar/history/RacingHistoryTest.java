package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.CarCollection;
import com.kakao.racingcar.domain.car.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingHistoryTest {

    @Test
    @DisplayName("레이싱 게임의 모든 라운드의 기록을 저장한다")
    void racingHistory() {
        RacingGame racingGame = new RacingGame(3, Arrays.asList("jyami", "mj"));
        racingGame.runRace();
        RacingHistory racingHistory = racingGame.getRacingHistory();
        assertThat(racingHistory.getResult().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("레이싱 게임의 모든 라운드의 위치를 저장한다")
    void racingHistoryAll() {

        RacingHistory racingHistory = makeRacingHistory();

        int position = 0;
        for (List<CarHistory> carHistories : racingHistory.getResult().values()) {
            assertThat(carHistories)
                    .containsExactly(new CarHistory(++position, "jyami"), new CarHistory(0, "mj"));
        }
    }

    private RacingHistory makeRacingHistory() {
        CarCollection carCollection = new CarCollection(Arrays.asList("jyami", "mj"));
        RacingHistory racingHistory = new RacingHistory();

        racingHistory.logging(new RoundHistory(1, carCollection.tryMoveCars(Arrays.asList(10, 0))));
        racingHistory.logging(new RoundHistory(2, carCollection.tryMoveCars(Arrays.asList(10, 0))));
        racingHistory.logging(new RoundHistory(3, carCollection.tryMoveCars(Arrays.asList(10, 0))));
        return racingHistory;
    }

    @Test
    @DisplayName("레이싱 게임의 마지막 라운드를 보고 승자 이름을 알려준다.")
    void getRacingWinner() {
        RacingHistory racingHistory = makeRacingHistory();
        List<String> winner = racingHistory.getWinner();
        assertThat(winner).containsExactly("jyami");
    }


}
