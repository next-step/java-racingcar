package study.racing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.domain.Name;
import study.racing.domain.result.GameResults;
import study.racing.domain.rule.RandcomNumberRule;
import study.racing.domain.rule.Rule;

class RacingGameServiceTest {

    private static Rule rule;

    @BeforeEach
    void setUp() {
        rule = new RandcomNumberRule();
    }

    @DisplayName("carCount와 tryCount를 전달했을 때, tryCount 만큼 게임을 진행했는지를 검증")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @MethodSource("validRacingCarsAndTryCount")
    void tryCountTest(List<Name> carNames, int tryCount) {
        RacingGameService racingGameService = new RacingGameService(rule);
        GameResults gameResults = racingGameService.race(carNames, tryCount);

        assertThat(gameResults.allRoundResults().size()).isEqualTo(tryCount);
    }

    private static Stream<Arguments> validRacingCarsAndTryCount() {
        int firstCarCount = 1;
        List<Name> firstCarNames = makeNames(firstCarCount);

        int secondCarCount = 100;
        List<Name> secondCarNames = makeNames(secondCarCount);

        return Stream.of(Arguments.of(firstCarNames, 10), Arguments.of(secondCarNames, 100));
    }

    private static List<Name> makeNames(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(Integer::toString)
                        .map(Name::new)
                        .collect(Collectors.toList());
    }

    @DisplayName("carNames와 tryCount를 전달했을 때, tryCpimt기 양수가 아니거나 car가 없다면 예외를 던진다")
    @ParameterizedTest(name = "carCount: {0}, tryCount: {1}")
    @MethodSource("invalidRacingCarsAndTryCount")
    void invalidCountTest(List<Name> carNames, int tryCount) {
        RacingGameService racingGameService = new RacingGameService(rule);
        assertThatThrownBy(() -> racingGameService.race(carNames, tryCount)).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> invalidRacingCarsAndTryCount() {
        List<Name> firstCarNames = new ArrayList<>();

        int secondCarCount = 1;
        List<Name> secondCarNames = makeNames(secondCarCount);

        return Stream.of(Arguments.of(firstCarNames, 10), Arguments.of(secondCarNames, 0));
    }
}
