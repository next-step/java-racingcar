package step3;

//  게임 생성 함수
class GameGenerator {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int gameCount = inputView.numberOfGame();
        int carCount = inputView.numberOfCar();

        RacingGame racingGame = new RacingGame(carCount);
        ResultView resultView = new ResultView();

        for (int i = 0; i < gameCount; i++) {
            racingGame.playRacingGame();
            resultView.showResult(racingGame.getRacingCarList());
        }

    }

}
