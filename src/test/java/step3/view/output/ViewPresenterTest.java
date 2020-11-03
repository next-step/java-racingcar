package step3.view.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.application.RacingCarSimulator;
import step3.application.SimulationCondition;
import step3.application.SimulationResult;

import static org.assertj.core.api.Assertions.assertThat;

class ViewPresenterTest {

    @DisplayName("시뮬레이션 결과가 비어있지 않은 경우 빈 문자열을 반환하지 않음")
    @Test
    void present_return_not_blank_when_simulationResult_is_not_empty() {
        // given
        final int numberOfCar = 3;
        final int numberOfAttempts = 5;
        final SimulationCondition condition = new SimulationCondition(numberOfCar, numberOfAttempts);
        final RacingCarSimulator simulator = new RacingCarSimulator(condition);
        final SimulationResult simulationResult = simulator.simulate();
        final ViewPresenter presenter = new ViewPresenter(simulationResult);

        // when
        final String result = presenter.present();

        // then
        assertThat(result).isNotBlank();
    }
}