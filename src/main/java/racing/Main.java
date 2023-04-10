package racing;

import static racing.ResultView.resultCars;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.userInput();

        resultCars(inputView.inputCarCount, inputView.tryCarCount);
    }
}
