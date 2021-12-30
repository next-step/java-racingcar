package repository;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    static final int CAR_NAME_LENGTH_BOUND = 5;
    static final int START_DISTANCE = 0;
    static final String STARTING_LINE = "";
    static final String START = "start";
    static final String WINNER = "win";

    public Cars(String carsName) {
        splitCarsName(carsName);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public void updateCar(int carIndex, Car targetCar) {
        cars.set(carIndex, targetCar);
    }

    public void updateWinnerCar(List<String> winner, int maxDistance, int distance, int carIndex) {
        if (distance == maxDistance) {
            cars.get(carIndex).setStatus(WINNER);
            winner.add(cars.get(carIndex).getName());
        }
    }

    public void addCars(String carName) {
        Car car = new Car(carName, STARTING_LINE, START_DISTANCE, START);
        cars.add(car);
    }

    public void splitCarsName(String carsName) {
        String[] carsList = carsName.split(",");
        for (int i = 0; i < carsList.length; i++) {
            validateNameLengthCheck(carsList[i]);
            addCars(carsList[i]);
        }
    }

    public void validateNameLengthCheck(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }

}
