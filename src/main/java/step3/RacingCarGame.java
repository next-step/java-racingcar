package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void playGame() {
        InputView inputView = new InputView();
        int carCount = inputView.inputCarCount();
        int tryCount = inputView.inputTryCount();

        List<Car> cars = makeCars(carCount);
        tryRound(cars, tryCount);
    }

    public List<Car> makeCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void tryRound(List<Car> cars, int tryCount) {
        ResultView resultView = new ResultView();
        resultView.printResult(cars, tryCount);
    }

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.playGame();
    }
}
