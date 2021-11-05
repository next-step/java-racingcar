package racingcar;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();

        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();
    }
}
