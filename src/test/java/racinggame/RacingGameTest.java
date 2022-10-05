package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("4 이상일 경우, 자동차가 전진한 결과를 반환해야 한다.")
    @Test
    void run_givenGreaterThanOrEqualTo4() {
        String carName = "car";
        RacingGame game = new RacingGame(new ConstantNumberGenerator(4));
        RacingGameResult actual = game.run(List.of(new Car("car")), 3);

        RacingGameResult expected = new RacingGameResult(
                List.of(
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 1))),
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 2))),
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 3)))
                )
        );
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3 보다 작을 경우, 자동차가 정지한 결과를 반환해야 한다.")
    @Test
    void run_givenLessThan3() {
        String carName = "car";
        RacingGame game = new RacingGame(new ConstantNumberGenerator(3));
        RacingGameResult actual = game.run(List.of(new Car(carName)), 3);

        RacingGameResult expected = new RacingGameResult(
                List.of(
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 0))),
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 0))),
                        new RacingGameRoundResult(List.of(new RacingGameCarResult(carName, 0)))
                )
        );
        assertThat(actual).isEqualTo(expected);
    }

}
