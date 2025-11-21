package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final String POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARK = "-";

    private final List<Car> cars;

    public Cars(List<CarName> names) {
        this.cars = createCars(names);
    }

    public static Cars fromCars(List<Car> cars) {
        Cars instance = new Cars(List.of());
        instance.cars.addAll(cars);
        return instance;
    }

    public List<Car> allCars() {
        return cars;
    }

    public void moveAll(Random random) {
        for (Car car : cars) {
            car.moveIfPossible(random.nextInt(MAX_RANDOM_VALUE));
        }
    }

    public List<String> roundResult() {
        List<String> roundResult = new ArrayList<>();
        for (Car car : cars) {
            String carStatus = car.name() + POSITION_SEPARATOR + POSITION_MARK.repeat(car.position().asInt());
            roundResult.add(carStatus);
        }
        return roundResult;
    }

    public List<String> winnerNames() {
        List<String> names = new ArrayList<>();
        for (CarName car : winners()) {
            names.add(car.toString());
        }
        return names;
    }

    private List<CarName> winners() {
        List<CarName> winners = new ArrayList<>();
        Position maxPosition = findMaxPosition();
        for (Car car : cars) {
            addWinnerIfMaxPosition(winners, car, maxPosition);
        }
        return winners;
    }

    private static void addWinnerIfMaxPosition(List<CarName> winners, Car car, Position maxPosition) {
        if (car.isAtSamePositionAs(maxPosition)) {
            winners.add(car.name());
        }
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.updateMax(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
