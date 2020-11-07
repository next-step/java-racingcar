package step5.worker.interfaces.presenter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.worker.application.SimulationRequest;
import step5.worker.application.SimulationResponse;
import step5.worker.application.SimulationResponseInteractor;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewPresenterTest {
    @DisplayName("시뮬레이션 결과가 비어있지 않은 경우 빈 문자열을 반환하지 않음")
    @Test
    void present_return_not_blank_when_simulationResult_is_not_empty() {
        // given
        final String carNames = "pobi,crong,honux";
        final String numberAttempts = "5";
        final SimulationRequest request = SimulationRequest.of(carNames, numberAttempts);
        final SimulationResponseInteractor simulator = new SimulationResponseInteractor();
        final SimulationResponse simulationResponse = simulator.interact(request);
        final ResultViewPresenter presenter = new ResultViewPresenter();

        // when
        final String result = presenter.present(simulationResponse);

        // then
        assertThat(result).isNotBlank();
    }
}