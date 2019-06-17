package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.RacingInfo;
import racing.dto.RacingResult;
import racing.random.StubValueGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService;
    private StubValueGenerator stubValueGenerator = new StubValueGenerator(0);

    @Test()
    @DisplayName("레이싱 후에 모든 결과를 정상적으로 저장한다")
    void run() {

        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        int attempts = 6;
        RacingInfo racingInfo = RacingInfo.of(carNames, attempts);
        racingService = new RacingService(racingInfo, stubValueGenerator);

        RacingResult racingResult = racingService.run();

        // 스코어보드의 개수가 시도 횟수와 일치하는지 검증
        assertThat(racingResult.getEntireRacingScore().size()).isEqualTo(attempts);
        // 모든 스코어보드에서 차의 개수와 CarNamePositions 개수와 일치하는지 검증
        racingResult.getEntireRacingScore().forEach(racingScore ->
                 assertThat(racingScore.getCarNamePositions().size()).isEqualTo(carNames.size()));
    }
}