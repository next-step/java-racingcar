package racingcar.usecase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RacingGamePlayUsecase 클래스")
class RacingGamePlayUsecaseTest {

    private final RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();
    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("play 메소드는")
    class DescribePlayMethod {

        private final RacingGamePlayRequest racingGamePlayRequest = new RacingGamePlayRequest(List.of(
            new CarRequest("win1", trueMover),
            new CarRequest("win2", trueMover),
            new CarRequest("loser", falseMover)
        ));

        @Nested
        @DisplayName("게임 한판을 진행하면,")
        class ContextCallMethod1Round {

            private final int round = 1;
            private final RacingGamePlayResponse expectedResult = getExpectedResult();

            @Test
            @DisplayName("게임 한판의 결과를 반환한다.")
            void ItReturnRaceGameResult() {
                RacingGamePlayResponse result = racingGamePlayUsecase.play(round, racingGamePlayRequest);

                Assertions.assertThat(result).isEqualTo(expectedResult);
            }

            private RacingGamePlayResponse getExpectedResult() {
                List<Car> cars = getCars();
                RacingGame racingGame = new RacingGame(cars);
                RacingGamePlayResponse racingGamePlayResponse = new RacingGamePlayResponse();

                racingGamePlayResponse.addRacingGameRoundResponse(0, cars);
                racingGame.play();
                racingGamePlayResponse.addRacingGameRoundResponse(1, racingGame.getRoundResult());
                racingGamePlayResponse.setWinner(racingGame.getWinners());
                return racingGamePlayResponse;
            }

        }

        @Nested
        @DisplayName("라운드 세번을 진행하면,")
        class ContextCallMethod3Round {

            private final int round = 3;
            private final RacingGamePlayResponse expectedResult = getExpectedResult();

            @Test
            @DisplayName("3번의 라운드에 대한 게임 결과를 반환한다.")
            void ItReturnRaceGameResult() {
                RacingGamePlayResponse result = racingGamePlayUsecase.play(round, racingGamePlayRequest);

                Assertions.assertThat(result).isEqualTo(expectedResult);
            }

            private RacingGamePlayResponse getExpectedResult() {
                List<Car> cars = getCars();
                RacingGame racingGame = new RacingGame(cars);
                RacingGamePlayResponse racingGamePlayResponse = new RacingGamePlayResponse();
                racingGamePlayResponse.addRacingGameRoundResponse(0, cars);
                for (int round = 1; round < 4; round++) {
                    racingGame.play();
                    racingGamePlayResponse.addRacingGameRoundResponse(round, racingGame.getRoundResult());
                }
                racingGamePlayResponse.setWinner(racingGame.getWinners());
                return racingGamePlayResponse;
            }

        }

        private List<Car> getCars() {
            return List.of(
                    new Car("win1", trueMover),
                    new Car("win2", trueMover),
                    new Car("loser", falseMover)
            );
        }

    }

}
