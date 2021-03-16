package ch01.step2;

import java.util.Random;

public class RacingGame {

    int attemptCount = 0;
    int carCount = 0;
    Car[] cars;

    public RacingGame() {

    }

    public RacingGame(InputView iv) {
        InputData inputData = iv.getInputData();

        //입력값 setting
        this.attemptCount = inputData.getAttemptCount();
        this.carCount = inputData.getCarCount();
        this.cars = new Car[this.carCount];

        //make cars
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(Integer.toString(i));
            cars[i] = car;
        }
    }

    private void start() {
        int randomNumber = 0;
        int carsSize = cars.length;
        for (int i = 0; i < carsSize; i++) {
            randomNumber = getRandomNumber();
            moveCar(this.cars, i, isKeepGoing(randomNumber));
        }
    }

    public void moveCar(Car[] cars, int index, boolean isKeepGoing) {
        if (isKeepGoing) {
            cars[index].move();
        }
    }


    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }

    public boolean isKeepGoing(int randomNumber) {
        return randomNumber > 3;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public static void main(String[] args) {
        //Input data
        InputView iv = new InputView();
        RacingGame racingGame = new RacingGame(iv);


        ResultView rv = new ResultView();
        //start racing game
        for (int i = 0; i < racingGame.getAttemptCount(); i++) {

            racingGame.start();

            //show a result of racing game
            rv.showResult(racingGame);
        }


    }


}
