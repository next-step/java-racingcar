package step2.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(1, carName));
        }
    }

    public Cars createCarsByCar(List<Car> carCollection) {
        return new Cars(carCollection);
    }

    public int extractNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String[] getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public List<String> retrieveWinners() {
        int maxPosition = getMaxPosition(this.cars);

        return this.cars.stream()
                .map(car -> getWinner(car, maxPosition))
                .filter(winner -> !"".equals(winner))
                .collect(toList());
    }

    private int getMaxPosition(List<Car> carCollection) {
        int maxPosition = 0;

        for (Car car : carCollection) {
            maxPosition = findMaxPosition(car, maxPosition);
        }

        return maxPosition;
    }

    private int findMaxPosition(Car car, int maxPosition) {
        return (car.isBiggerThan(maxPosition)) ? car.getPosition() : maxPosition;
    }

    private String getWinner(Car car, int maxPosition) {
        String winnerName = "";

        if (car.getPosition() == maxPosition) {
            winnerName = car.getName();
        }
        return winnerName;
    }
}
