package step3;

public class GameStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCnt = inputView.getCarCnt();
        int gameCnt = inputView.getGameCnt();

        RacingGame racingGame = new RacingGame(carCnt);
        ResultView resultView = new ResultView();

        for (int i = 0; i < gameCnt; i++) {
            racingGame.play();
            resultView.showResult(racingGame.getCarList());
        }
    }
}
