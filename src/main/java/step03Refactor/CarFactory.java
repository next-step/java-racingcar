package step03Refactor;

import java.util.*;
import java.util.stream.Collectors;

import static step03Refactor.Config.CAR_DELIMITER;
import static step03Refactor.Config.ERROR_INPUT_CAR_NAME_LENGTH;

public class CarFactory {
    private final List<Car> cars = new ArrayList<>();

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
        Car maxPositionCar = findMaxPositionCar();

        return cars.stream().filter(car -> {
            return car.isWinner(maxPositionCar.getCarPosition());
        }).collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream().max(Comparator.comparingInt(Car::getCarPosition)).orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_CAR_NAME_LENGTH));
    }

    public String getWinnerName() {
        int winnerCount = 0;
        StringBuilder winnersName = new StringBuilder();
        for (Car car : getWinners()) {
            winnerCount++;
            winnersName.append(new CarDTO(car).getWinnerName(winnerCount));
        }
        return winnersName.toString();
    }

    public List<CarDTO> getCarData() {
        List<CarDTO> carData = new ArrayList<>();
        for (Car car : cars) {
            carData.add(new CarDTO(car));
        }
        return carData;
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
