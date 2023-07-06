package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.domain.response.RacingGamePlayResponse;

@Nested
@DisplayName("RacingGamePlayController 클래스")
class RacingGamePlayControllerTest {

    @Nested
    @DisplayName("playRacingGame 메소드는")
    class DescribePlayRacingGameMethod {

        @Nested
        @DisplayName("round값이 5, car이름이 pobi, crong, honux인 입력값들이 들어온다면,")
        class ContextCallMethod {

            private static final int DEFAULT_ROUND = 1;

            private final int round = 5;
            private final List<String> carNames = List.of("pobi", "crong", "honux");
            private final RacingGamePlayController controller = new RacingGamePlayController();
            private final RacingGamePlayControllerRequest request
                = new RacingGamePlayControllerRequest(round, carNames);

            @Test
            @DisplayName("5판을 진행하고, pobi, crong, honux중 우승자들의 이름과 각 라운드값을 리턴한다.")
            void ItReturnCollectResponse() {
                RacingGamePlayResponse result = controller.playRacingGame(request);
                assertControllerResponse(carNames, result);
            }

            private void assertControllerResponse(List<String> containExpectedNames,
                RacingGamePlayResponse response) {

                assertThat(response.getWinnerNames()).containsAnyOf(containExpectedNames.toArray(String[]::new));
                assertThat(response.getRacingGameRoundResponses()).hasSize(round + DEFAULT_ROUND);
            }

        }

    }

}