package racing;

public class CarCircuit {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int racingCount = InputView.inputRacingCount();

        Circuit circuit = new Circuit(carCount, racingCount);
        circuit.startRacing();

        ResultView outView = new ResultView();
        outView.view(circuit);
    }
}
