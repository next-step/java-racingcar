package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class Racing {
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
        return new Cars(inputCarNames);
    }

    private void race() {
        Random random = new Random();
        for (int i = 0; i < cars.count(); i++) {
            Car car = cars.findOne(i);
            car.move(RacingRule.moveOrStop(random.nextInt(10)));
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
