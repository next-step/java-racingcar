package step3.controller;

import step3.model.Car;
import step3.view.ResultView;

import java.util.Random;

public class CarRacing {

    int numOfCars;
    int numOfTries;

    public CarRacing(int cars, int tries) {
        this.numOfCars = cars;
        this.numOfTries = tries;
    }

    public void playTime(){
        Car[] cars= new Car[numOfCars];

        for(int i=0; i< cars.length;i++){
            cars[i] = new Car();
        }

        for(int i=0; i< numOfTries;i++){
            GoGocing(cars, numOfCars);
            ResultView.resultShow(cars);
        }
    }
    void GoGocing(Car[] cars, final int numOfCars ){

        Random random = new Random();

        for(int i=0; i< numOfCars;i++){
            int randomValue = random.nextInt(10);

            cars[i].move(randomValue);
        }
    }
}


