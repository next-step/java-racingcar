package racing.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.dto.RacingInfo;
import racing.dto.RacingResult;
import racing.random.StubValueGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService;
    private StubValueGenerator stubValueGenerator = new StubValueGenerator(0);

    @ParameterizedTest(name = "레이싱 후에 모든 결과를 정상적으로 저장한다. carNames={0}, attempts={1}")
    @MethodSource
    void run(List<String> carNames, int attempts) {

        RacingInfo racingInfo = RacingInfo.of(carNames, attempts);
        racingService = new RacingService(racingInfo, stubValueGenerator);

        RacingResult racingResult = racingService.run();

        // 스코어보드의 개수가 시도 횟수와 일치하는지 검증
        assertThat(racingResult.getEntireRacingScore().size()).isEqualTo(attempts);
        // 모든 스코어보드에서 차의 개수와 CarNamePositions 개수와 일치하는지 검증
        racingResult.getEntireRacingScore().forEach(
                racingScore -> assertThat(racingScore.getCarNamePositions().size()).isEqualTo(carNames.size()));
    }

    private static Stream<Arguments> run() {

        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), 6),
                Arguments.of(Arrays.asList("c", "y", "w"), 3),
                Arguments.of(Arrays.asList("1", "22", "333"), 20)
        );
    }
}