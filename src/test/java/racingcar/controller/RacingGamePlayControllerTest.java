package racingcar.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.domain.extension.Moveable;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

@Nested
@DisplayName("RacingGamePlayControllerTest")
class RacingGamePlayControllerTest {

    @Nested
    @DisplayName("playRacingGame 메소드는")
    class DescribePlayRacingGameMethod {

        private final Moveable trueMover = () -> true;
        private final Moveable falseMover = () -> false;
        private final RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();

        @Nested
        @DisplayName("올바른 request가 전달되면,")
        class ContextCallMethod {

            private final RacingGamePlayController controller
                = new RacingGamePlayController(racingGamePlayUsecase);
            private final RacingGamePlayControllerRequest request
                = new RacingGamePlayControllerRequest(5, List.of("pobi", "crong", "honux"));
            private final RacingGamePlayControllerResponse expectedResponse = getExpectedResponse();

            @Test
            @DisplayName("올바른 응답을 리턴한다.")
            void ItReturnCollectResponse() {
                RacingGamePlayControllerResponse result = controller.playRacingGame(request);
                Assertions.assertThat(result).isEqualTo(expectedResponse);
            }

            private RacingGamePlayControllerResponse getExpectedResponse() {
                RacingGamePlayResponse racingGamePlayResponse = racingGamePlayUsecase.play(5, new RacingGamePlayRequest(
                    List.of(
                        new CarRequest("A", falseMover),
                        new CarRequest("B", falseMover),
                        new CarRequest("C", trueMover)
                    )
                ));
                return new RacingGamePlayControllerResponse(racingGamePlayResponse);
            }

        }

    }
}