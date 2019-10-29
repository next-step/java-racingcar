package step2;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int trialNum = inputView.getTrialNum();

        RacingGame racingGame = new RacingGame(carNum, trialNum);
        racingGame.doGame();

    }
}
