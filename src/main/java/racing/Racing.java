package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    public int try_count;
    public ArrayList<Car> cars;

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
        cars = new ArrayList<>();
        for (int i = 0; i < inputCarCount; i++) {
            cars.add(new Car());
        }
    }

    private void race() {
        Random random = new Random();
        for (Car car : cars) {
            car.status += RacingRule.goOrStop(random.nextInt(10));
        }
    }
}
