package step3;

import java.io.PrintWriter;
import java.util.Scanner;

public class RacingGame {
    private static InputView inputView = new InputView(new Scanner(System.in), new PrintWriter(System.out, true));
    private static Integer carCount;
    private static Integer tryCount;
    private static Simulator simulator = new Simulator();


    public static void main(String[] args) {
        loadGameEnvironmentFromInputView();
        simulateGame();
        printSimulationResult();
    }

    private static void loadGameEnvironmentFromInputView() {
        carCount = inputView.getCarCountFromInput();
        tryCount = inputView.getTryCountFromInput();
    }

    private static void simulateGame() {
        simulator.execute(carCount, tryCount);
    }

    private static void printSimulationResult() {
        simulator.printResult();
    }

}
