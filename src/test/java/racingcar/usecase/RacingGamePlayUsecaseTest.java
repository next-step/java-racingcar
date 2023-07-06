package racingcar.usecase;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.extension.Moveable;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RacingGamePlayUsecase 클래스")
class RacingGamePlayUsecaseTest {

    private static final int ROUND_OFFSET = 1;

    private final RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();
    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("play 메소드는")
    class DescribePlayMethod {

        @Nested
        @DisplayName("게임 한판을 진행하면,")
        class ContextCallMethod1Round {

            private final RacingGamePlayRequest racingGamePlayRequest = new RacingGamePlayRequest(
                List.of(new CarRequest("win1", trueMover), new CarRequest("win2", trueMover),
                    new CarRequest("loser", falseMover)));
            private final int round = 1;

            @Test
            @DisplayName("게임 한판의 결과를 반환한다.")
            void ItReturnRaceGameResult() {
                RacingGamePlayResponse result = racingGamePlayUsecase.play(round, racingGamePlayRequest);

                assertRacingGamePlayResult(round, List.of("win1", "win2"), result);
            }

        }

        @Nested
        @DisplayName("라운드 세번을 진행하면,")
        class ContextCallMethod3Round {

            private final RacingGamePlayRequest racingGamePlayRequest = new RacingGamePlayRequest(
                List.of(new CarRequest("win", trueMover), new CarRequest("loser", falseMover)));
            private final int round = 3;

            @Test
            @DisplayName("3번의 라운드에 대한 게임 결과를 반환한다.")
            void ItReturnRaceGameResult() {
                RacingGamePlayResponse result = racingGamePlayUsecase.play(round, racingGamePlayRequest);

                assertRacingGamePlayResult(round, List.of("win"), result);
            }

        }

        private void assertRacingGamePlayResult(int round, List<String> winnerNames, RacingGamePlayResponse result) {
            Assertions.assertThat(result.getWinnerNames()).containsAll(winnerNames);
            Assertions.assertThat(result.getRacingGameRoundResponses()).hasSize(round + ROUND_OFFSET);
        }

    }

}
