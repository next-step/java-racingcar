package step2.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(1, carName));
        }
    }

    public int extractNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String[] getCarNames() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        return carNames.toArray(new String[carNames.size()]);
    }

    public List<String> retrieveWinners() {
        int maxPosition = getMaxPosition(this.cars);

        return this.cars.stream()
                .map(car -> getWinner(car, maxPosition))
                .filter(winner -> !winner.equals(""))
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
        return (car.getPosition() > maxPosition) ? car.getPosition() : maxPosition;
    }

    private String getWinner(Car car, int maxPosition) {
        String winnerName = "";

        if (car.getPosition() == maxPosition) {
            winnerName = car.getName();
        }
        return winnerName;
    }
}
