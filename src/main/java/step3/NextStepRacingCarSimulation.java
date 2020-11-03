package step3;

import step3.application.RacingCarSimulator;
import step3.application.SimulationCondition;
import step3.application.SimulationResult;
import step3.view.input.InputView;
import step3.view.output.Printer;
import step3.view.output.ResultView;

public class NextStepRacingCarSimulation {
    public static void main(String[] args) {
        // 조건을 받고
        final SimulationCondition condition = receiveCondition();
        
        // 시뮬레이션을 한 결과를 받아와
        final SimulationResult result = simulate(condition);
        
        // 형식에 맞게 출력
        printResult(result);
    }
    
    private static SimulationCondition receiveCondition() {
        return InputView.receiveSimulationCondition();
    }

    private static SimulationResult simulate(final SimulationCondition condition) {
        final RacingCarSimulator simulator = new RacingCarSimulator(condition);
        return simulator.simulate();
    }

    private static void printResult(final SimulationResult simulationResult) {
        final ResultView resultView = new ResultView(simulationResult);
        Printer.print(resultView);
    }
}
