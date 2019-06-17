package racing.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.dto.RacingInfo;
import racing.dto.RacingResult;
import racing.random.StubValueGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService;
    private StubValueGenerator stubValueGenerator = new StubValueGenerator(0);

    @ParameterizedTest(name = "레이싱 후에 모든 결과를 정상적으로 저장하고, 출력한다. (carNames={0}, attempts={1})")
    @CsvSource(value = "pobi,crong,honux:6", delimiter = ':')
    void run(String carNames, int attempts) {

        RacingInfo racingInfo = RacingInfo.of(carNames, attempts);
        racingService = new RacingService(racingInfo, stubValueGenerator);

        RacingResult racingResult = racingService.run();

        assertThat(racingResult.size()).isEqualTo(attempts);
        // TODO : 케이스 보충
        assertThat(racingResult.getLastRacingPosition().entrySet().size()).isEqualTo(3);
    }
}