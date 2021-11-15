package study.racing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.racing.model.result.GameResults;
import study.racing.model.rule.RandcomNumberRule;
import study.racing.model.rule.Rule;

class RacingGameServiceTest {

    @DisplayName("carCount와 tryCount를 전달했을 때, tryCount 만큼 게임을 진행했는지를 검증")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @CsvSource({ "1, 1", "100, 100" })
    void tryCountTest(int carCount, int tryCount) {
        Rule rule = new RandcomNumberRule();
        RacingGameService racingGameService = new RacingGameService(rule);
        List<String> carNames = getNames(carCount);

        GameResults gameResults = racingGameService.race(carNames, tryCount);

        assertThat(gameResults.round()).isEqualTo(tryCount);
    }

    private List<String> getNames(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.toList());
    }

    @DisplayName("carCount와 tryCount를 전달했을 때, 두 값 중 하나라도 양수가 아니면 예외를 던진다")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @CsvSource({ "0, 1", "1, 0", "-1, 1", "1, -1" })
    void invalidCountTest(int carCount, int tryCount) {
        Rule rule = new RandcomNumberRule();
        RacingGameService racingGameService = new RacingGameService(rule);
        List<String> carNames = getNames(carCount);

        assertThatThrownBy(() -> racingGameService.race(carNames, tryCount)).isInstanceOf(RuntimeException.class);
    }
}
