package game;

import message.Message;
import uiview.ResultView;

public class PreparedCarGame{

    private final ResultView resultView = new ResultView();
    private GameStrategy gameStrategy;

    public void ready(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    //레이싱을 시작한다.
    public void startRace() {
        System.out.println(Message.RESULT_MESSAGE.message());
        for (int i = 0; i < gameStrategy.getAttemptNum(); i++) {
            this.gameStrategy.attemptForwardCar();
            raceResult();
        }
    }

    //현재 레이스의 결과를 출력한다.
    private void raceResult() {
        resultView.resultView(gameStrategy.getRacingCars());
    }

}
