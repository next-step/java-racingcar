package racingcar.model;

import racingcar.model.action.RandomMovable;

import java.util.ArrayList;

public class CarRacingInformation {
    private ArrayList<Car> carList;
    private RandomMovable randomMovable;
    private int carRacingCount;


    public CarRacingInformation(int numberOfCar, int carRacingCount) {
        isZeroOrLess(numberOfCar);
        isZeroOrLess(carRacingCount);
        makeCarList(numberOfCar);
        randomMovable = new RandomMovable();
        this.carRacingCount = carRacingCount;
    }

    private void makeCarList(int numberOfCar) {
        carList = new ArrayList<>(numberOfCar);
        for (int i = 0; i<numberOfCar; i++) {
            carList.add(new Car());
        }
    }

    public void isZeroOrLess(int number) {
        if (number <= 0 ) {
            throw new IllegalArgumentException("입력값이 0 이하입니다.");
        }
    }


    public ArrayList<Car> getCarList() {
        return carList;
    }


    public ArrayList<Car> decideMovable() {
        for (int carIdx = 0; carIdx< carList.size(); carIdx++) {
            decideMovableByRandomValue(carIdx);
        }
        return carList;
    }

    public void decideMovableByRandomValue(int carIdx) {
        int randomValue = randomMovable.makeRandomValue();
        if (randomMovable.moveOrNot(randomValue)) {
            carList.get(carIdx).move();
        }
    }

    public boolean checkCarRacingCount() {
        return carRacingCount > 0;
    }

    public void minusCarRacingCount() {
        carRacingCount--;
    }


    public int getCarRacingCount() {
        return carRacingCount;
    }
}
