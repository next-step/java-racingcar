package step3.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.RacingRound;
import step3.ui.dto.RequestRacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {

    @DisplayName("레이싱 게임 정상 작동 테스트")
    @ParameterizedTest(name = "자동차 {0} 대, 총 {1} 차 레이스 시작")
    @CsvSource(value = {"2, 3", "4, 2"})
    void racingGameTest(int participants, int attemptCount) {
        // given
        RequestRacingGame request = new RequestRacingGame(participants, attemptCount);
        CarRacingGame racingGame = new CarRacingGame(request);

        // when
        racingGame.race();

        // then
        List<RacingRound> result = racingGame.getRacingResult();
        assertThat(result.size()).isEqualTo(attemptCount);
    }
}
