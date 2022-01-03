package service;

import domain.Car;
import repository.Cars;
import repository.Winner;

import java.util.List;

public class CarService {

    Cars cars;
    Winner winner;
    static final int CAR_MOVE_CONDITION = 4;

    public CarService(String carsName) {
        this.cars = new Cars(carsName);
        this.winner = new Winner();
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
        for (int i = 0; i < cars.getCars().size(); i++) {
            winner.findWinnerCar(cars.getCar(i), maxDistance);
        }
        return winner.getWinnerCar();
    }
}
