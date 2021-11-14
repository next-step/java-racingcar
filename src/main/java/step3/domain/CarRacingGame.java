package step3.domain;

import step3.view.dto.InputDto;

import java.util.ArrayList;
import java.util.List;

import static step3.utils.RandomUtil.random;


public class CarRacingGame {

    private static final int MAX_RANDOM_VALUE = 10;

    private int totalRound;
    private final List<Car> cars = new ArrayList<>();

    public static CarRacingGame of(InputDto inputDto) {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.totalRound = inputDto.getNumberOfAttempts();
        int numberOfCars = inputDto.getNumberOfCars();
        carRacingGame.addNewCars(numberOfCars);
        return carRacingGame;
    }

    private void addNewCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void play() {
        for (int round = 0; round < totalRound; round++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            int randomNumber = random(MAX_RANDOM_VALUE);
            CarOperation operatoin = CarOperation.from(randomNumber);
            car.move(operatoin);
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int round = 0; round < totalRound; round++) {
            for (Car car : cars) {
                int position = car.getPosition(round);
                for (int i = 0; i < position; i++) {
                    sb.append("-");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}