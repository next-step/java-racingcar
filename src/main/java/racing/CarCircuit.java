package racing;

public class CarCircuit {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.inputCarCount();
        int racingCount = inputView.inputRacingCount();

        Circuit circuit = new Circuit(carCount, racingCount);
        circuit.startRacing();

        ResultView outView = new ResultView();
        outView.view(circuit);
    }
}
