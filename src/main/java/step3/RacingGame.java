package step3;

import step3.domain.GameEnvironment;
import step3.domain.SimulationStep;
import step3.domain.Simulator;
import step3.view.InputView;
import step3.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private static final InputView inputView;
    private static final Simulator simulator;
    private static final PrintWriter output;
    private static final ResultView resultView;
    private static final GameEnvironment gameEnvironment;

    static {
        output = new PrintWriter(System.out, true);
        inputView = new InputView(new Scanner(System.in), output);
        simulator = new Simulator();
        resultView = new ResultView(output);
        gameEnvironment = new GameEnvironment();
    }

    public static void main(String[] args) {
        loadGameEnvironmentFromInputView();
        simulateGame();
        showSimulationResult();
        closeOutput();
    }

    private static void loadGameEnvironmentFromInputView() {
        gameEnvironment.setCar(inputView.getCarCountFromInput());
        gameEnvironment.setTry(inputView.getTryCountFromInput());
    }

    private static void simulateGame() {
        simulator.setGameEnvironment(gameEnvironment);
        simulator.execute();
    }

    private static void showSimulationResult() {
        resultView.show(simulator.getSimulationResult().stream().map(SimulationStep::toString).collect(Collectors.toList()));
    }

    private static void closeOutput() {
        output.close();
    }

}
