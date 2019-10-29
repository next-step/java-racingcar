package step2;

public class RacingGame {
    private int time;
    private int[] carPositions;

    public void startGame() {
        setGameData();
    }

    private void setGameData() {
        InputView inputView = new InputView();
        this.time = inputView.getTrialNum();
        this.carPositions = new int[inputView.getCarNum()];
    }


}
