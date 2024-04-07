package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.domain.RacingCar;
import step5.domain.RacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step5.common.Constant.NATURAL_FIRST;

@DisplayName("RacingCar 테스트")
public class RacingCarTest {

    @DisplayName("전진 테스트")
    @Test
    void forward() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> true);
        assertThat(racingCar.position() > NATURAL_FIRST).isTrue();
    }

    @DisplayName("멈춤 테스트")
    @Test
    void hold() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> false);
        assertThat(racingCar.position() == NATURAL_FIRST).isTrue();
    }

    @DisplayName("자동차 경주 우승자 테스트")
    @ParameterizedTest
    @MethodSource("testRacingGame")
    public void winner(RacingGame racingGame, List<String> winners) {
        assertThat(racingGame.winners().containsAll(winners)).isTrue();
        assertThat(winners.containsAll(racingGame.winners())).isTrue();

    }

    private static Stream<Arguments> testRacingGame() {
        RacingGame racingGameIncludeOneWinner = new RacingGame();
        racingGameIncludeOneWinner.list().add(new RacingCar(1, "apple", 4));
        racingGameIncludeOneWinner.list().add(new RacingCar(2, "bana", 5));
        racingGameIncludeOneWinner.list().add(new RacingCar(3, "cat", 6));

        RacingGame racingGameIncludeMultiWinners = new RacingGame();
        racingGameIncludeMultiWinners.list().add(new RacingCar(4, "dear", 7));
        racingGameIncludeMultiWinners.list().add(new RacingCar(5, "egg", 8));
        racingGameIncludeMultiWinners.list().add(new RacingCar(6, "fruit", 8));

        return Stream.of(
                Arguments.of(racingGameIncludeOneWinner, List.of("cat")),
                Arguments.of(racingGameIncludeMultiWinners, Arrays.asList("egg", "fruit"))
        );
    }

}
