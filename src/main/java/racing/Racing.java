package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class Racing {
    public int try_count;
    public Cars cars;

    public static Racing input() {
        InputView inputView = InputView.create();
        return new Racing(inputView.car_count,inputView.try_count);
    }

    public Racing(int inputCarCount, int inputTryCount) {
        if(isNegative(inputCarCount,inputTryCount)){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        makeCars(inputCarCount);
        this.try_count = inputTryCount;
    }

    private boolean isNegative(int inputCarCount, int inputTryCount) {
        return inputCarCount < 0 || inputTryCount < 0;
    }

    public void raceAndShowResult() {
        ResultView.start();
        for (int i = 0; i < try_count; i++) {
            race();
            ResultView.showRace(cars);
        }
    }

    private void makeCars(int inputCarCount) {
        cars = new Cars();
        for (int i = 0; i < inputCarCount; i++) {
            cars.add();
        }
    }

    private void race() {
        Random random = new Random();
        for (int i = 0; i < cars.count(); i++) {
            Car car = cars.find(i);
            car.move(RacingRule.moveOrStop(random.nextInt(10)));
        }

    }
}
