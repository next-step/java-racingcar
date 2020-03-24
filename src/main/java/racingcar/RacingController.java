package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingController {

    public static final int FIRST = 1;
    private int carCount;
    private int tryCount;
    private static List<Car> cars;
    private final RandomNumber randomNumber = new RandomNumber();
    private Map<Integer, List<Integer>> record;

    public RacingController(InputView inputView) {
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
        ResultView resultView = new ResultView(this.record);
        resultView.show();
    }

    private List<Integer> changePosition() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : getCars()) {
            Car movedCar = car.changeCarPosition(car, randomNumber.getRandomNumber());
            positions.add(movedCar.getPosition());
        }
        return positions;
    }

    public static List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
