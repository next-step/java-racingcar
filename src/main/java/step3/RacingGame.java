package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private int round;
    private List<Car> carList;

    public void startGame() {
        InputView inputView = new InputView();

        inputView.init();
        inputView.showInputCarMessage();
        carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        round = inputView.inputRound();

        makeCarList(carNumber);
        playGame(carList, round);
    }

    private void makeCarList(int carNumber) {
        carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(0);
            carList.add(car);
        }
    }

    private void playGame(List<Car> cars, int round) {
        ResultView resultView = new ResultView();
        resultView.showResultMessage();

        for (int i =0; i<round; i++) {
            playEachRound(cars);
            resultView.printRoundResult(cars);
        }
    }

    private void playEachRound(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.position++;
            }
        }
    }

    private boolean isMovable() {
        return getRandomNumber() >= Constants.MOVE_CONDITION;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
