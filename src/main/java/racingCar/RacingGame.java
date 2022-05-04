package racingCar;

public class RacingGame {
    public void startGame() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Cars cars = new Cars(inputView.nameList());
        NumberOfGame numberOfGame = new NumberOfGame(inputView.numberOfGame());

        System.out.println("\n실행 결과");
        while (!numberOfGame.isEndGame()) {
            resultView.resultOfCars(cars);
            numberOfGame.decreaseNumberOfGame();
        }
        resultView.resultOfWinners(cars);
    }
}
