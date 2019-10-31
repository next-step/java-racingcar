package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

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

    public List<String> retrieveWinners() {
        List<String> winners = new ArrayList<>();
        List<Car> carCollection = this.cars.getCars();

        int maxPosition = getMaxPosition(carCollection);

        return carCollection.stream()
                .map(car -> getWinner(car, maxPosition))
                .filter(winner -> !winner.equals(""))
                .collect(toList());
    }

    public int getMaxPosition(List<Car> carCollection) {
        int maxPosition = 0;

        for (Car car : carCollection) {
            maxPosition = findMaxPosition(car, maxPosition);
        }

        return maxPosition;
    }

    public int findMaxPosition(Car car, int maxPosition) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
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