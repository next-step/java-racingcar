package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RacingGameTest {

    RacingGame racingGame;

    private int carCount = 2;
    private int roundCount = 2;

    static Stream<Arguments> carList() {
        return Stream.of(
                arguments(Lists.list(new Car(1), new Car(1)))
        );
    }

    @Test
    @DisplayName("생성자 테스트")
    void createRacingGame() {
        racingGame = new RacingGame(carCount, roundCount);
        assertNotNull(racingGame);
    }

    @ParameterizedTest
    @DisplayName("모든 차가 모든 라운드에 전진한 게임 테스트")
    @MethodSource("carList")
    void runRound(List<Car> carList) {
        List<Round> expected = new ArrayList<>(roundCount);
        for (int i = 0; i < roundCount; i++) {
            expected.add(new Round(Cars.of(carList)));
        }

        List<Round> actual = new RacingGame(carCount, expected.size()).runGame(() -> true);
        assertEquals(expected, actual);
    }

}
