package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static Cars cars;

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfGames = InputView.getNumberOfGames();

        createCar(numberOfCars);
        playRacingGame(numberOfGames);
    }

    private static void createCar(int numberOfCars) {
        List<Car> listOfCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            listOfCars.add(new Car(i));
        }
        cars = new Cars(listOfCars);
    }

    public static void playRacingGame(int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
        }
    }
}

