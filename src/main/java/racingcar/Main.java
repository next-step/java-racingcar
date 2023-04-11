package racingcar;

public class Main {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        RacingCar racingCar = new RacingCar();
        RandomGenerator randomGenerator = new RandomGenerator();

        resultView.questionCarCountMessage();
        int carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        int tryCount = inputView.getInput();

        resultView.printNewLine();

    }
}