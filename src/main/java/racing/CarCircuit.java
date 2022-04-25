package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.Scanner;

public class CarCircuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carNames = InputView.inputCarNames(scanner);
        int racingCount = InputView.inputRacingCount(scanner);

        Circuit circuit = new Circuit(carNames, racingCount);
        circuit.startRacing();

        ResultView.view(circuit);
    }
}
