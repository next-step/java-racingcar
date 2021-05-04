package racing.domain;

import java.util.*;

public class Cars {
    private static final int MINIMUM_NUMBER_OF_CARS = 1;
    public static final String DELIMITER = ",";

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String carNames, MovableStrategy movableStrategy) {
        validate(carNames);
        String[] splitCarNames = carNames.split(DELIMITER);
        validate(splitCarNames);
        return new Cars(mapCars(splitCarNames, movableStrategy));
    }

    private static void validate(String carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 차이름이 없습니다.");
        }
    }

    private static void validate(String[] carNames) {
        if (carNames.length < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("최소 1대 이상 필요합니다.");
        }
    }

    private static List<Car> mapCars(String[] carNames, MovableStrategy movableStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, movableStrategy));
        }
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Winners findWinners() {
        Distance farthestDistance = findFarthestDistance();
        List<String> farthestCars = new ArrayList<>();
        cars.forEach(car -> addWinner(car, farthestDistance, farthestCars));
        return Winners.of(farthestCars);
    }

    private Distance findFarthestDistance() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0).getDistance();
    }

    private void addWinner(Car car, Distance farthestDistance, List<String> farthestCars) {
        if (car.isSameDistance(farthestDistance)) {
            farthestCars.add(car.carName());
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
