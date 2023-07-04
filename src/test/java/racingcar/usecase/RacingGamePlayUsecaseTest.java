package racingcar.usecase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.usecase.response.RacingGamePlayResponse;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RacingGamePlayUsecase 클래스")
class RacingGamePlayUsecaseTest {

    private final RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();
    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("play 메소드는")
    class DescribePlayMethod {

        @Nested
        @DisplayName("게임 한판을 진행하면,")
        class ContextCallMethod {

            private final int round = 1;
            private final Car[] cars = {
                new Car("win1", trueMover),
                new Car("win2", trueMover),
                new Car("loser", falseMover),
            };
            private final RacingGame racingGame = new RacingGame(cars);
            private final RacingGamePlayResponse expectedResult = new RacingGamePlayResponse();

            @Test
            @DisplayName("게임 한판의 결과를 반환한다.")
            void ItReturnRaceGameResult() {
                RacingGamePlayResponse result = racingGamePlayUsecase.play(round, racingGame);

                Assertions.assertThat(result).isEqualTo(expectedResult);
            }
        }
    }

}
