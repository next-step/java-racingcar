package ch01.racinggame.domain;


public class RacingGame {

    private int attemptCount = 0;
    private int carCount = 0;
    private Car[] cars;

    private static RandomNumber randomNumber = new RandomNumber();


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

    public Car[] start() {
        int carsSize = cars.length;

        for (int i = 0; i < carsSize; i++) {
            isMovableCar(cars[i]);
        }
        return cars;
    }


    private void isMovableCar(Car car){
        if(randomNumber.movable()){
            car.move();
        }
    }


    public Winner winner() {

        Winner winner = new Winner(this.cars);

        return winner;
    }

    public int attemptCount() {
        return this.attemptCount;
    }

    public Car[] cars() {
        return cars;
    }


}
