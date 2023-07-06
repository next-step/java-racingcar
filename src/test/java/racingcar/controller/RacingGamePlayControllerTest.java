package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.usecase.RacingGamePlayUsecase;

@Nested
@DisplayName("RacingGamePlayController 클래스")
class RacingGamePlayControllerTest {

    @Nested
    @DisplayName("playRacingGame 메소드는")
    class DescribePlayRacingGameMethod {

        @Nested
        @DisplayName("올바른 request가 전달되면,")
        class ContextCallMethod {

            private static final int DEFAULT_ROUND = 1;

            private final int round = 5;
            private final List<String> carNames = List.of("pobi", "crong", "honux");
            private final RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();
            private final RacingGamePlayController controller
                = new RacingGamePlayController(racingGamePlayUsecase);
            private final RacingGamePlayControllerRequest request
                = new RacingGamePlayControllerRequest(round, carNames);

            @Test
            @DisplayName("올바른 응답을 리턴한다.")
            void ItReturnCollectResponse() {
                RacingGamePlayControllerResponse result = controller.playRacingGame(request);
                assertControllerResponse(carNames, result);
            }

            private void assertControllerResponse(List<String> containExpectedNames,
                RacingGamePlayControllerResponse response) {

                assertThat(response.getWinnerNames()).containsAnyOf(containExpectedNames.toArray(String[]::new));
                assertThat(response.getRacingGameRoundResponses()).hasSize(round + DEFAULT_ROUND);
            }

        }

    }

}