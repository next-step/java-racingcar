package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";

    private int numberOfCars;
    private Cars cars;

    public RacingGame(String nameOfCars) {
        String[] carNames = splitCarNameInput(nameOfCars);
        cars = new Cars();

        cars.createCars(carNames);

        this.numberOfCars = cars.extractNumberOfCars();
    }

    public String[] splitCarNameInput(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

    public List<String> selectWinners() {
        List<String> winners = new ArrayList<>();

        return getWinners(winners, this.cars);
    }

    public List<String> getWinners(List<String> winners, Cars cars) {
        List<Car> carCollection = cars.getCars();

        int maxPosition = getMaxPosition(carCollection);

        for (Car car : carCollection) {
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

    public int getMaxPosition(List<Car> carCollection) {
        int maxPosition = 0;

        for (Car car : carCollection) {
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


    public Cars move() {
        int length = numberOfCars;
        int position;
        int resultPosition;

        List<Car> carCollection = cars.getCars();

        for (int i = 0; i < length; i++) {
            position = carCollection.get(i).getPosition();
            resultPosition = iterateCarMove(position);
            carCollection.get(i).setPosition(resultPosition);
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

    public Cars getCars() {
        return this.cars;
    }
}