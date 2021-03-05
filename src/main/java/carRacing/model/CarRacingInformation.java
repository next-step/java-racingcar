package carRacing.model;

import java.util.ArrayList;

public class CarRacingInformation {
    private ArrayList<Car> carList;
    private int carRacingCount;

    public CarRacingInformation(int numberOfCar, int carRacingCount) {
        validate(numberOfCar);
        validate(carRacingCount);
        carList = new ArrayList<>(numberOfCar);
        for(int i = 0; i<numberOfCar;i++) {
            carList.add(new Car());
        }
        this.carRacingCount = carRacingCount;
    }

    private void validate(int numberOfCar) {

    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public boolean checkCarRacingCount() {
        return carRacingCount > 0 ? true : false;
    }

    public void decideMovable() {
        for(Car car : carList) {
            car.decideMovable();
        }
    }

    public void minusCarRacingCount() {
        carRacingCount--;
    }

}
