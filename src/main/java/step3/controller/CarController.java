package step3.controller;

import step3.domain.Cars;

public class CarController {

    private Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(int numOfCars) {
        cars = new Cars(numOfCars);
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
}
