package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";

    private int numberOfCars;
    private Car[] cars;
    private String[] carNames;

    public RacingGame(String nameOfCars) {
        this.carNames = splitCarNameInput(nameOfCars);
        this.numberOfCars = extractNumberOfCars(this.carNames);
        this.cars = new Car[this.numberOfCars];
        setCars(this.cars);
    }

    public String[] splitCarNameInput(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

    public int extractNumberOfCars(String[] carNames) {
        return carNames.length;
    }

    public void setCars(Car[] cars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car(1, carNames[i]);
        }
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public List<String> selectWinners() {
        List<String> winners = new ArrayList<>();

        return getWinners(winners, this.cars);
    }

    public List<String> getWinners(List<String> winners, Car[] cars) {
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            winners = exceptEmpty(winners, getWinner(car, maxPosition));
        }

        return winners;
    }

    public List<String> exceptEmpty(List<String> winners, String winner) {
        if (!winner.equals("")) {
            winners.add(winner);
        }
        return winners;
    }

    public int getMaxPosition(Car[] cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }

    public String getWinner(Car car, int maxPosition) {
        String winnerName = "";
        if (car.getPosition() == maxPosition) {
            winnerName = car.getName();
        }
        return winnerName;
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