package repository;

import domain.Car;
import service.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private static final int START_DISTANCE = 0;
    private static final String COMMA = ",";

    public Cars(String carsName) {
        splitCarsName(carsName);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(String carName) {
        Car car = new Car(carName, START_DISTANCE);
        cars.add(car);
    }

    public void splitCarsName(String carsNames) {
        String[] carName = carsNames.split(COMMA);
        for (int i = 0; i < carName.length; i++) {
            addCars(carName[i]);
        }
    }

    public List<Car> carsMove() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = RandomNumber.makeRandomNumber();
            cars.get(i).updateDistance(randomNumber);
        }
        return cars;
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            int distance = cars.get(i).getDistance();
            maxDistance = checkMaxDistance(maxDistance, distance);
        }
        return maxDistance;
    }

    public int checkMaxDistance(int maxDistance, int distance) {
        if (distance > maxDistance) {
            return distance;
        }
        return maxDistance;
    }

    public List<String> findMaxDistanceCar(int maxDistance) {
        Winner winner = new Winner();
        for (int i = 0; i < cars.size(); i++) {
            winner.findWinnerCar(cars.get(i), maxDistance);
        }
        return winner.getWinnerCar();
    }

}
