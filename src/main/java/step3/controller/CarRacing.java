package step3.controller;

import step3.model.Car;
import step3.model.CarRecord;
import step3.utility.ReturnValue;

public class CarRacing {

    private int numOfCars;
    private int numOfTries;
    private Car[] cars;
    private CarRecord[] carRecord;


    public CarRacing(int numOfCars, int numOfTries) {
        validate(numOfCars, numOfTries);
        this.numOfCars = numOfCars;
        this.numOfTries = numOfTries;
        cars = new Car[numOfCars];
        carRecord = new CarRecord[numOfCars];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
            carRecord[i] = new CarRecord();
        }
    }

    public void validate(int numOfCars, int numOfTries) {
        checkCars(numOfCars);
        checkTries(numOfTries);
    }

    private void checkCars(int numOfCars) {
        if (numOfCars < 0) {
            throw new IllegalArgumentException("numofcar_인풋에러");
        }
    }

    private void checkTries(int numOfTries) {
        if (numOfTries < 0) {
            throw new IllegalArgumentException("numoftry_인풋에러");
        }
    }

    public void gameStart() {
        for (int i = 0; i < numOfTries; i++) {
            run();
        }
    }

    void run() {
        for (int i = 0; i < numOfCars; i++) {
            cars[i].move(ReturnValue.returnValue());
            carRecord[i].resultRecording(cars[i].getPosition());
        }
    }

    public CarRecord[] getCarRecord() {
        return carRecord;
    }
}


