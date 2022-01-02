package service;

import domain.Car;
import repository.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    Cars cars;
    static final int CAR_MOVE_CONDITION = 4;

    public CarService(String carsName) {
        this.cars = new Cars(carsName);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void carsMove(int carIndex, int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            cars.getCar(carIndex).updateDistance();
        }
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (int i = 0; i < cars.getCars().size(); i++) {
            int distance = cars.getCar(i).getDistance();
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
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < cars.getCars().size(); i++) {
            int distance = cars.getCar(i).getDistance();
            cars.checkWinnerCar(winner, maxDistance, distance, i);
        }
        return winner;
    }
}
