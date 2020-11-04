package step3;

import step3.application.RacingCarSimulator;
import step3.application.SimulationCondition;
import step3.application.SimulationResult;
import step3.view.output.presenter.ResultViewPresenter;
import step3.view.input.InputView;
import step3.view.output.ResultView;

public class NextStepRacingCarSimulation {
    public static void main(String[] args) {
        // 외부에서 조건을 받고
        final SimulationCondition condition = receiveCondition();

        // 조건을 기준으로 시뮬레이션을 한 결과를 받고
        final SimulationResult simulationResult = simulate(condition);

        // 보여질 결과를 만드는 Presenter에 시뮬레이션결과를 전달
        final ResultViewPresenter resultViewPresenter = new ResultViewPresenter(simulationResult); 
        
        // 'Presenter'를 주입 받아 외부 화면에 출력
        ResultView.print(resultViewPresenter);
    }

    private static SimulationCondition receiveCondition() {
        return InputView.receiveSimulationCondition();
    }

    private static SimulationResult simulate(final SimulationCondition condition) {
        final RacingCarSimulator simulator = new RacingCarSimulator(condition);
        return simulator.simulate();
    }
}
