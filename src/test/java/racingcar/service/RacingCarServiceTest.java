package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceReadyValue;
import racingcar.dto.RaceResultValue;
import racingcar.domain.TesterMotor;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTest {

    @DisplayName("play() 테스트 : 랜덤하게 경주한 결과값 DTO를 정상적으로 반환하는지 확인")
    @Test
    void play() {
        String carNames = "jin,hyun,hwi";
        int tryCount = 3;

        RaceReadyValue raceReadyValue = RaceReadyValue.of(carNames, tryCount);
        RaceResultValue play = RacingCarService.play(raceReadyValue, new TesterMotor());

        assertThat(play.getStepCount()).isEqualTo(tryCount);
    }
}
