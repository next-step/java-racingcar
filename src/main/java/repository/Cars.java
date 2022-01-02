package repository;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    static final int START_DISTANCE = 0;
    static final String COMMA = ",";
    static final boolean WINNER = false;

    public Cars(String carsName) {
        splitCarsName(carsName);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public void checkWinnerCar(List<String> winner, int maxDistance, int distance, int carIndex) {
        if (distance == maxDistance) {
            cars.get(carIndex).updateWinner();
            winner.add(cars.get(carIndex).getName());
        }
    }

    public void addCars(String carName) {
        Car car = new Car(carName, START_DISTANCE, WINNER);
        cars.add(car);
    }

    public void splitCarsName(String carsNames) {
        String[] carName = carsNames.split(COMMA);
        for (int i = 0; i < carName.length; i++) {
            addCars(carName[i]);
        }
    }

}
