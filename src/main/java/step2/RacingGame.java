package step2;

import java.util.Random;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";

    private int numberOfCars;
    private Car[] cars;
    private String[] carNames;

    public RacingGame(String nameOfCars) {
        this.carNames = splitCarNameInput(nameOfCars);
        this.numberOfCars = getNumberOfCars(this.carNames);
        System.out.println(this.numberOfCars);
        this.cars = new Car[this.numberOfCars];
        setCars(this.cars);
    }

    public String[] splitCarNameInput(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

    public int getNumberOfCars(String[] carNames) {
        return carNames.length;
    }

    public void setCars(Car[] cars) {
        for(int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car(1, carNames[i]);
        }
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public Car[] move() {
        int length = numberOfCars;
        int position;
        int resultPosition;

        for (int i = 0; i < length; i++) {
            position = this.cars[i].getPosition();
            resultPosition = iterateCarMove(position);
            this.cars[i].setPosition(resultPosition);
        }

        return this.cars;
    }

    public int iterateCarMove(int position) {
        int randomNumber = generateRandom();
        int movedPosition = position;

        movedPosition = moveForward(randomNumber, movedPosition);

        return movedPosition;
    }

    public int generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public int moveForward(int number, int position) {
        if (number >= 4) {
            position = position + 1;
        }

        return position;
    }
}