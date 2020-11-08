package step5.client.worker.interfaces.presenter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.client.worker.application.RacingGameRequest;
import step5.client.worker.application.RacingGameResponse;
import step5.client.worker.application.RacingGameInteractor;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewPresenterTest {
    @DisplayName("시뮬레이션 결과가 비어있지 않은 경우 빈 문자열을 반환하지 않음")
    @Test
    void present_return_not_blank_when_simulationResult_is_not_empty() {
        // given
        final String carNames = "pobi,crong,honux";
        final String numberAttempts = "5";
        final RacingGameRequest request = RacingGameRequest.of(carNames, numberAttempts);
        final RacingGameInteractor simulator = new RacingGameInteractor();
        final RacingGameResponse racingGameResponse = simulator.interact(request);
        final ResultViewPresenter presenter = new ResultViewPresenter();

        // when
        final String result = presenter.present(racingGameResponse);

        // then
        assertThat(result).isNotBlank();
    }
}