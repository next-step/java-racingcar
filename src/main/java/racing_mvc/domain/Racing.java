package racing_mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final String SPLIT_NAMES_DELIMITER = ",";
    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    private final RacingRound racingRound;
    private final Cars cars;

    public Racing(String inputCarNames, int inputTryCount) {
        racingRound = new RacingRound(inputTryCount);
        cars = makeCars(inputCarNames);
    }

    private Cars makeCars(String inputCarNames) {
        List<Car> newCars = new ArrayList<>();
        for (String carName : splitCarNames(inputCarNames)) {
            newCars.add(new Car(carName));
        }
        return new Cars(newCars);
    }

    private String[] splitCarNames(String inputCarNames) {
        return inputCarNames.split(SPLIT_NAMES_DELIMITER);
    }

    public Cars race() {
        for (int i = 0; i < cars.count(); i++) {
            cars.findOne(i).move(RANDOM.nextInt(BOUND_NUMBER));
        }
        return cars;
    }

    public Winner winner() {
        return new Winner(cars);
    }

    public int getCarsCount() {
        return cars.count();
    }

    public int getTryCount(){
        return racingRound.getRound();
    }

    public Car getCar(int carIndex){
        return cars.findOne(carIndex);
    }
}