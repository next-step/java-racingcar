package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int carCount;
    private int tryCount;
    private static List<Car> cars;
    private final RandomNumber randomNumber = new RandomNumber();

    public RacingGame(InputView inputView) {
        carCount = inputView.getNumberOfCars();
        tryCount = inputView.getNumberOfTries();
        cars = new ArrayList<>();
    }

    public void startGame() {
        createCar();
        tryMoveCar();
        startMove();
    }

    private void createCar() {
        for (int carNumber = 1; carNumber <= carCount; carNumber++) {
            cars.add(new Car(carNumber));
        }
    }

    private void tryMoveCar() {
        System.out.println("실행 결과");
        for (int i = 1; i < tryCount; i++) {
            startMove();
        }
        System.out.println();
    }

    private void startMove() {
        for (Car car : getCars()) {
            car.changeCarPosition(randomNumber.getRandomNumber());
            Graph graph = new Graph(car);
            graph.getCarGraph();
        }
    }

    public static List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
