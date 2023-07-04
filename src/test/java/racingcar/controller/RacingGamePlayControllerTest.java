package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.usecase.RacingGamePlayUsecase;

@Nested
@DisplayName("RacingGamePlayControllerTest")
class RacingGamePlayControllerTest {

    @Nested
    @DisplayName("playRacingGame 메소드는")
    class DescribePlayRacingGameMethod {

        @Nested
        @DisplayName("올바른 request가 전달되면,")
        class ContextCallMethod {

            private final RacingGamePlayController controller
                = new RacingGamePlayController(new RacingGamePlayUsecase());
            private final RacingGamePlayControllerRequest request = new RacingGamePlayControllerRequest();
            private final RacingGamePlayControllerResponse expectedResponse = new RacingGamePlayControllerResponse();

            @Test
            @DisplayName("올바른 응답을 리턴한다.")
            void ItReturnCollectResponse() {
                RacingGamePlayControllerResponse result = controller.playRacingGame(request);
                Assertions.assertThat(result).isEqualTo(expectedResponse);
            }

        }

    }

}
