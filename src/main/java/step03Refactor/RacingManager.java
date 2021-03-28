package step03Refactor;


public class RacingManager {

    private CarFactory carFactory;
    private RoundCount roundCount;

    public RacingManager(String carNames, int tryCount) {
        carFactory = new CarFactory(carNames);
        roundCount = new RoundCount(tryCount);
    }

    public RacingManager() {
        carFactory = new CarFactory(InputView.inputRacingCarNames());
        roundCount = new RoundCount(InputView.inputRacingTryCount());
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        while (!roundCount.isFinishRound()) {
            carFactory.racing(moveStrategy);
            showRacingRoundResult();
        }
        showRacingRoundFinalWinner();
    }

    private void showRacingRoundResult() {
        ResultView.showRacingResult(carFactory.getCarData());
    }

    private void showRacingRoundFinalWinner() {
        ResultView.showRacingWinner(carFactory.getWinnerName());
    }

}
