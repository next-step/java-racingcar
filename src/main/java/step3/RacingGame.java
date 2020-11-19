package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static int carNumber;
    private static int round;
    private static List<Car> carList;
    private static Random random = new Random();

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.init();
        inputView.showInputCarMessage();
        carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        round = inputView.inputRound();

        makeCarList(carNumber);
        playGame(carList, round);
    }

    public static List<Car> makeCarList(int carNumber) {
        carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(Constants.STARTING_POINT);
            carList.add(car);
        }

        return carList;
    }

    private static void playGame(List<Car> cars, int round) {
        ResultView resultView = new ResultView();
        resultView.showResultMessage();

        for (int i =0; i<round; i++) {
            playEachRound(cars);
            resultView.printRoundResult(cars);
        }
    }

    private static void playEachRound(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private static void moveCar(Car car) {
        if (isMovable()) {
            car.position++;
        }
    }

    private static boolean isMovable() {
        return getRandomNumber() >= Constants.MOVE_CONDITION;
    }

    private static int getRandomNumber() {
        return random.nextInt(Constants.RANDOM_RANGE);
    }

}
