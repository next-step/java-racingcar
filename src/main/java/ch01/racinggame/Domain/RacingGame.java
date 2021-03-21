package ch01.racinggame.Domain;


import java.util.ArrayList;

public class RacingGame {

    int attemptCount = 0;
    int carCount = 0;
    Car[] cars;
    RandomNumber randomNumber = new RandomNumber();

    public RacingGame(InputData inputData) {

        //입력값 setting
        this.attemptCount = inputData.attemptCount();
        this.carCount = inputData.carCount();
        this.cars = new Car[this.carCount];

        makeCar(inputData.carNames());
    }

    private void makeCar(String[] carNames) {
        //make cars
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(carNames[i]);
            cars[i] = car;
        }
    }

    public void start() {
        int carsSize = cars.length;

        for (int i = 0; i < carsSize; i++) {
            moveCar(this.cars, i, randomNumber.randomNumber());
        }
    }

    public void moveCar(Car[] cars, int index, int randomNum) {
        if (randomNumber.movable(randomNum)) {
            cars[index].move();
        }
    }

    public ArrayList<Car> winner(){
        Winner winner = new Winner(this.cars);

        return winner.whoAreWinners();
    }

    public int attemptCount() {
        return this.attemptCount;
    }

    public boolean isKeepGoing(int randomNumber) {
        return randomNumber > 3;
    }

    public Car[] cars() {
        return cars;
    }


}
