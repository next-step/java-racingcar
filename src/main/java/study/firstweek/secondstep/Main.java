package study.firstweek.secondstep;

public class Main {

    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView result = new ResultView();

        int carCount = input.getNumberOfCars();
        int trialCount = input.getNumberOfTrials();

        RacingGame racingGame = new RacingGame(carCount, trialCount);
        result.printResult(racingGame.startGame(), trialCount);
    }
}
