package racing;

import racing.ui.InputView;
import racing.ui.ResultView;
import racing.RacingRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final String SPLIT_NAMES_DELIMITER = ",";
    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    private final RacingRound racingRound;
    private final Cars cars;

    public static Racing input() {
        InputView inputView = InputView.create();
        return new Racing(inputView.getCarNames(),inputView.getTryCount());
    }

    public Racing(String inputCarNames, int inputTryCount) {
        racingRound = new RacingRound(inputTryCount);
        cars = makeCars(inputCarNames);
    }

    public void raceAndShow() {
        ResultView.start();
        for (int i = 0; i < racingRound.getRound(); i++) {
            race();
            ResultView.showRace(cars);
        }
        Winner winner = new Winner(cars);
        ResultView.showWinners(winner);
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

    private void race() {
        for (int i = 0; i < cars.count(); i++) {
            cars.findOne(i).move(RANDOM.nextInt(BOUND_NUMBER));
        }
    }

    public int getCarsCount() {
        return cars.count();
    }

    public int getTryCount(){
        return racingRound.getRound();
    }

    public String getCarName(int carIndex){
        return cars.findOneName(carIndex);
    }
}
