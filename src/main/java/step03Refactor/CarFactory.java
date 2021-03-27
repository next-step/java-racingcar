package step03Refactor;

import java.util.*;
import java.util.stream.Collectors;

public class CarFactory {
    private final List<Car> cars = new ArrayList<>();
    private static final String MOVE_RANGE = "-";
    private static final String DELIMITER = " : ";
    static final String CAR_DELIMITER = ",";

    public CarFactory(String carNames) {
        makeCars(carNames);
    }

    public CarFactory(List<Car> cars) {
        for (Car car : cars) {
            moveCars(car);
        }
    }

    public void racing(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public void moveCars(Car car) {
        cars.add(car);
    }

    public void makeCars(String carNames) {
        List<String> splitNames = splitCarName(carNames);
        for (String carName : splitNames) {
            cars.add(new Car(carName));
        }
    }

    private List<String> splitCarName(String carNames) {
        return Arrays.asList(carNames.split(CAR_DELIMITER));
    }

    public List<Car> getWinners() {
        int finalMaxPosition = cars.stream().max(Comparator.comparingInt(Car::getCarPosition)).get().getCarPosition();

        return cars.stream().filter(car -> {
            return car.isWinner(finalMaxPosition);
        }).collect(Collectors.toList());
    }

    public String getWinnerName() {
        StringBuilder winnersName = new StringBuilder();
        for (Car car : getWinners()) {
            addDelimiter(winnersName);
            winnersName.append(car.getCarName());
        }
        return winnersName.toString();
    }

    private void addDelimiter(StringBuilder winnerName) {
        if (winnerName.length() > 0) {
            winnerName.append(CAR_DELIMITER);
        }
    }

    public String getCarResultDataToString() {
        StringBuilder carData = new StringBuilder();
        for (Car car : cars) {
            carData.append(car.getCarName()).append(DELIMITER).append(getCarMoveRangeToString(car)).append("\n");
        }
        return carData.toString();
    }

    private String getCarMoveRangeToString(Car car) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < car.getCarPosition(); i++) {
            position.append(MOVE_RANGE);
        }
        return String.valueOf(position);
    }

    public int getCarsSize() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarFactory that = (CarFactory) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
