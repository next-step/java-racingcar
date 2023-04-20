package step4;

public class RacingGame {
    private int tryCount;
    private Cars cars;
    private ResultView resultView;

    public RacingGame(ResultView resultView, RacingGameInputData inputData) {
        this.resultView = resultView;
        this.tryCount = inputData.getTryCount();
        this.cars = Cars.of(inputData.getCarNames());
    }

    public void race(Dice dice) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(dice);
            resultView.logScore(cars);
        }
        resultView.setWinners(cars.getWinners());
        resultView.printResult();
    }


}
