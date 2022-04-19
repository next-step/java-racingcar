package racingCar;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.inputList.get(0));

        StartGame startGame = new StartGame();

        startGame.racingCarGame(inputView.inputList.get(0), inputView.inputList.get(1), cars.carList);

    }
}
