package racing;

import java.util.Scanner;

public class CarCircuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = InputView.inputCarCount(scanner);
        int racingCount = InputView.inputRacingCount(scanner);

        Circuit circuit = new Circuit(carCount, racingCount);
        circuit.startRacing();

        ResultView.view(circuit);
    }
}
