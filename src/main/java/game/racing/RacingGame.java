package game.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private Random random;

    public RacingGame(String carNames) {
        this.cars = createCars(carNames.split(","));
        this.random = new Random();
    }

    List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public GameResult move() {

        for (Car car : cars) {
            int moveNumber = this.random.nextInt(10);
            car.move(moveNumber);
        }

        return new GameResult(cars);
    }

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames);
        GameResult result = null;
        for (int i = 0; i < tryNo; i++) {
            result = racingGame.move();
            ResultView.print(result);
        }
        ResultView.printWinner(result);
    }

}
