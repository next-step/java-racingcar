package step3.controller;

import step3.model.Car;
import step3.view.ResultView;

import java.util.Random;

public class CarRacing {

    int numOfCars;
    int numOfTries;
    Car[] cars;
    int[][] recordCarMove;
    final int RANDOM_MAX_VALUE = 10;


    public CarRacing(int numOfCars, int numOfTries) {
        validate(numOfCars,numOfTries);
        this.numOfCars = numOfCars;
        this.numOfTries = numOfTries;
        cars= new Car[numOfCars];
        recordCarMove = new int[numOfTries][numOfCars];

        for(int i=0; i< cars.length;i++){
            cars[i] = new Car();
        }
    }

    public void validate(int numOfCars,int numOfTries){
        checkCars(numOfCars);
        checkTries(numOfTries);
    }

    private void checkCars(int numOfCars){
        if(numOfCars < 0){
            throw new IllegalArgumentException("numofcar_인풋에러");
        }
    }
    private void checkTries(int numOfTries){
        if(numOfTries < 0){
            throw new IllegalArgumentException("numoftry_인풋에러");
        }
    }


    public int[][] gameStart(){
        for(int i=0; i< numOfTries;i++){
            run(i,cars);
        }
        return recordCarMove;
    }

    void run(int tries, Car[] cars){
        Random random = new Random();

        for(int i=0; i< numOfCars;i++){
            cars[i].move(createRandom(random));
            recordCarMove[tries][i] =cars[i].getPosition();
        }
    }

    public int createRandom(Random random){
        return random.nextInt(RANDOM_MAX_VALUE);
    }

}


