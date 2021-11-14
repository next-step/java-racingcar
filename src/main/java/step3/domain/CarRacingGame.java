package step3.domain;

import step3.view.dto.InputDto;

import java.util.List;
import java.util.function.IntSupplier;

import static step3.utils.RandomUtil.random;


public class CarRacingGame {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final int BOUND = 4;


    private int totalRound;
    private Cars cars;

    public static CarRacingGame of(InputDto inputDto) {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.totalRound = inputDto.getNumberOfAttempts();
        int numberOfCars = inputDto.getNumberOfCars();
        carRacingGame.cars = new Cars(numberOfCars);
        return carRacingGame;
    }


    public void play() {
        for (int round = 0; round < totalRound; round++) {
            cars.playOneRound(gameRule());
        }
    }

    private IntSupplier gameRule() {
        return ()->{
            int randomNumber = random(MAX_RANDOM_VALUE);
            if (randomNumber >= BOUND) {
                return 1;
            }
            return 0;
        };
    }


    public int getTotalRound() {
        return totalRound;
    }


    public List<Integer> getCarsPosition(int round) {
        return cars.getPosition(round);
    }
}