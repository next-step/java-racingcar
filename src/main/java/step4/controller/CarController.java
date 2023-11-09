package step4.controller;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(String[] nameOfCars) {
        cars = new Cars(nameOfCars);
    }

    public void moveCar(int randomNum, int carNo) {
        cars.findCarBy(carNo).moveForward(randomNum);
    }

    public int[] findPositions() {
        int numOfCar = cars.getNumOfCars();

        int[] positions = new int[numOfCar];
        for (int i=0; i<numOfCar; i++) {
            positions[i] = cars.findCarBy(i).getCurrentPosition();
        }

        return positions;
    }

    public List<String> findWinners(int numOfTry) {
        List<String> winners = new ArrayList<>();

        for (int distance = numOfTry; distance >= 0; distance--) {
            winners = findCarNameMovingLongest(distance);

            if (!winners.isEmpty()) {
                break;
            }
        }

        return winners;
    }

    private List<String> findCarNameMovingLongest(int distance) {
        List<String> winners = new ArrayList<>();

        for (int j = 0; j< cars.getNumOfCars(); j++) {
            Car car = cars.findCarBy(j);

            if (car.getCurrentPosition() == distance) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }
}
