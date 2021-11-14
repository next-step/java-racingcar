package study.racing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.racing.model.Result;
import study.racing.model.rule.RandcomNumberRule;
import study.racing.model.rule.Rule;

class RacingGameServiceTest {

    @DisplayName("carCount와 tryCount를 전달했을 때, tryCount 만큼 게임을 진행했는지를 검증")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @CsvSource({ "1, 1", "100, 100" })
    void tryCountTest(int carCount, int tryCount) {
        Rule rule = new RandcomNumberRule();
        RacingGameService racingGameService = new RacingGameService(rule);

        List<Result> results = racingGameService.race(carCount, tryCount);

        assertThat(results.size()).isEqualTo(tryCount);
    }

    @DisplayName("carCount와 tryCount를 전달했을 때, carCount 만큼 자동차가 생성되었는지 검증")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @CsvSource({ "1, 1", "100, 100" })
    void carCountTest(int carCount, int tryCount) {
        Rule rule = new RandcomNumberRule();
        RacingGameService racingGameService = new RacingGameService(rule);

        List<Result> results = racingGameService.race(carCount, tryCount);

        assertThat(results.get(0).getResult().size()).isEqualTo(carCount);
    }

    @DisplayName("carCount와 tryCount를 전달했을 때, 두 값 중 하나라도 양수가 아니면 예외를 던진다")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @CsvSource({ "0, 1", "1, 0", "-1, 1", "1, -1" })
    void invalidCountTest(int carCount, int tryCount) {
        Rule rule = new RandcomNumberRule();
        RacingGameService racingGameService = new RacingGameService(rule);

        assertThatThrownBy(() -> racingGameService.race(carCount, tryCount)).isInstanceOf(RuntimeException.class);
    }
}
