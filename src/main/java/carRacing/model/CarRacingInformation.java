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

    public void validate(int number) {
        if(number <= 0 ) {
            throw new IllegalArgumentException("입력값이 0 이하입니다.");
        }
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

    public int getCarRacingCount() {
        return carRacingCount;
    }
}
