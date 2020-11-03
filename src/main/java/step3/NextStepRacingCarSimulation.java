package step3;

import step3.application.RacingCarSimulator;
import step3.application.SimulationCondition;
import step3.application.SimulationResult;
import step3.view.output.ViewPresenter;
import step3.view.input.InputView;
import step3.view.output.ResultView;

public class NextStepRacingCarSimulation {
    public static void main(String[] args) {
        // 조건을 받고
        final SimulationCondition condition = receiveCondition();

        // 시뮬레이션을 한 결과를 받아와
        final SimulationResult simulationResult = simulate(condition);

        // 보여질 결과를 만드는 Presenter 생성
        final ViewPresenter viewPresenter = new ViewPresenter(simulationResult); 
        
        // 'Presenter'를 주입 받아 화면에 출력
        ResultView.print(viewPresenter);
    }

    private static SimulationCondition receiveCondition() {
        return InputView.receiveSimulationCondition();
    }

    private static SimulationResult simulate(final SimulationCondition condition) {
        final RacingCarSimulator simulator = new RacingCarSimulator(condition);
        return simulator.simulate();
    }
}
