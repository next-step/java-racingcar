package step3;

import step3.domain.GameEnvironment;
import step3.domain.Simulator;
import step3.view.InputView;
import step3.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;

public class RacingGame {
    private static final InputView inputView;
    private static final PrintWriter output;
    private static final ResultView resultView;
    private static GameEnvironment gameEnvironment;
    private static Simulator simulator;

    static {
        output = new PrintWriter(System.out, true);
        inputView = new InputView(new Scanner(System.in), output);
        resultView = new ResultView(output);
    }

    private RacingGame() {
    }

    public static void main(String[] args) {
        loadGameEnvironmentFromInputView();
        simulateGame();
        showSimulationResult();
        closeOutput();
    }

    private static void loadGameEnvironmentFromInputView() {
        gameEnvironment = new GameEnvironment(inputView.getCarCountFromInput(), inputView.getTryCountFromInput());
    }

    private static void simulateGame() {
        simulator = new Simulator(gameEnvironment);
        simulator.execute();
    }

    private static void showSimulationResult() {
        resultView.show(simulator.getSimulationResult());
    }

    private static void closeOutput() {
        output.close();
    }

}
