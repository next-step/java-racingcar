package step3;

import step3.application.RacingCarSimulator;
import step3.application.SimulationCondition;
import step3.application.SimulationResult;
import step3.interfaces.input.InputView;
import step3.interfaces.output.Printer;
import step3.interfaces.output.ResultView;

public class NextStepRacingCarSimulation {
    public static void main(String[] args) {
        final SimulationCondition condition = InputView.receiveSimulationCondition();
        final SimulationResult simulationResult = simulate(condition);
        printResult(simulationResult);
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
