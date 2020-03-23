package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    public static final int FIRST = 1;
    private int carCount;
    private int tryCount;
    private static List<Car> cars;
    private final RandomNumber randomNumber = new RandomNumber();
    private Map<Integer, List<Integer>> record;

    public RacingGame(InputView inputView) {
        carCount = inputView.getCarCount();
        tryCount = inputView.getTryCount();
        cars = new ArrayList<>();
        record = new HashMap<>();
    }

    public void startGame() {
        createCar();
        tryMoveCar();
        resultShow();
    }

    private void createCar() {
        for (int carNumber = 1; carNumber <= carCount; carNumber++) {
            cars.add(new Car(carNumber));
        }
    }

    private void tryMoveCar() {
        for (int count = FIRST; count <= tryCount; count++) {
            record.put(count, changePosition());
        }
    }

    private void resultShow() {
        Graph graph = new Graph(this.record);
        graph.show();
    }

    private List<Integer> changePosition() {
        List<Integer> position = new ArrayList<>();

        for (Car car : getCars()) {
            car.changeCarPosition(randomNumber.getRandomNumber());
            position.add(car.getPosition());
        }
        return position;
    }

    public static List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
