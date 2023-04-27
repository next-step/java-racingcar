package step2.racing_mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final String SPLIT_NAMES_DELIMITER = ",";
    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    private final RacingGameRound racingRound;
    private final RacingCars cars;

    public RacingGame(String inputCarNames, int inputTryCount) {
        racingRound = new RacingGameRound(inputTryCount);
        cars = makeCars(inputCarNames);
    }

    private RacingCars makeCars(String inputCarNames) {
        List<RacingCar> newCars = new ArrayList<>();
        for (String carName : splitCarNames(inputCarNames)) {
            newCars.add(new RacingCar(carName));
        }
        return new RacingCars(newCars);
    }

    private String[] splitCarNames(String inputCarNames) {
        return inputCarNames.split(SPLIT_NAMES_DELIMITER);
    }

    public RacingCars race() {
        for (int i = 0; i < cars.count(); i++) {
            cars.findOne(i).move(RANDOM.nextInt(BOUND_NUMBER));
        }
        return cars;
    }

    public RacingGameWinner winner() {
        return new RacingGameWinner(cars);
    }

    public int getCarsCount() {
        return cars.count();
    }

    public int getTryCount(){
        return racingRound.getRound();
    }

    public RacingCar getCar(int carIndex){
        return cars.findOne(carIndex);
    }
}