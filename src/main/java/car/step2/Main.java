package car.step2;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String inputString = inputView.inputString();
        int result = StringAddCalculator.splitAndSum(inputString);
        resultView.outputNumber(result);
    }
}
