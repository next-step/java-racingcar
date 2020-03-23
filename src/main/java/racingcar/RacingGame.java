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
    List<Integer> positions;
    private final RandomNumber randomNumber = new RandomNumber();

    public RacingGame(InputView inputView) {
        carCount = inputView.getCarCount();
        tryCount = inputView.getTryCount();
        cars = new ArrayList<>();
        positions = new ArrayList<>();
    }

    public void startGame() {
        createCar();
        tryMoveCar();
    }

    private void createCar() {
        for (int carNumber = 1; carNumber <= carCount; carNumber++) {
            cars.add(new Car(carNumber));
        }
    }

    private void tryMoveCar() {
        Map<Integer, List<Integer>> record = new HashMap<>();

        for (int count = FIRST; count <= tryCount; count++) {
            record.put(count,  startMove());
        }
        Graph graph = new Graph(record);
        graph.show();
    }

    private List<Integer> startMove() {
        List<Integer> position = new ArrayList<>();

        for (Car car : getCars()) {
            car.changeCarPosition(randomNumber.getRandomNumber());
            position.add(car.getPosition());
        }
        return position;
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }

    public static List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
