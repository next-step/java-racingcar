package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void playGame() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

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
        ResultView.printResult(cars, tryCount);
    }

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.playGame();
    }
}
