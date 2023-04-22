package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final String SPLIT_NAMES_DELIMITER = ",";
    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    private final int try_count;
    private final Cars cars;

    public static Racing input() {
        InputView inputView = InputView.create();
        return new Racing(inputView.getCarNames(),inputView.getTryCount());
    }

    public Racing(String inputCarNames, int inputTryCount) {
        validatePositve(inputTryCount);
        cars = makeCars(inputCarNames);
        try_count = inputTryCount;
    }

    private void validatePositve(int inputTryCount) {
        if (inputTryCount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public void raceAndShow() {
        ResultView.start();
        for (int i = 0; i < try_count; i++) {
            race();
            ResultView.showRace(cars);
        }
        Winner winner = new Winner(cars);
        ResultView.showWinner(winner.getName());
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
        return try_count;
    }

    public String getCarName(int carIndex){
        return cars.findOneName(carIndex);
    }
}
