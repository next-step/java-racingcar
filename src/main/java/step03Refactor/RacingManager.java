package step03Refactor;


public class RacingManager {

    private CarFactory carFactory;
    private int totalRoundCount = 0;
    private int currentRoundCount = 0;

    public RacingManager(String carNames, int tryCount) {
        carFactory = new CarFactory(carNames);
        totalRoundCount = tryCount;
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        while (!isFinishRound()) {
            carFactory.racing(moveStrategy);
            showRacingRoundResult();
        }
        showRacingRoundFinalWinner();
    }

    private boolean isFinishRound() {
        if (totalRoundCount > currentRoundCount) {
            currentRoundCount++;
            return false;
        }
        return true;
    }

    private void showRacingRoundResult() {
        ResultView.showRacingResult(carFactory.getCarResultDataToString());
    }

    private void showRacingRoundFinalWinner() {
        ResultView.showRacingWinner(carFactory.getWinnerName());
    }

}
