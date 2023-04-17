package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class Racing {
    public int try_count;
    public Cars cars;

    public static Racing input() {
        InputView inputView = InputView.create();
        return new Racing(inputView.car_names,inputView.try_count);
    }

    public Racing(String inputCarNames, int inputTryCount) {
        validatePositve(inputTryCount);
        makeCars(inputCarNames);
        this.try_count = inputTryCount;
    }

    private void validatePositve(int inputTryCount) {
        if(inputTryCount < 0){
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
        ResultView.showWinner(winner.name);
    }

    private void makeCars(String inputCarNames) {
        cars = new Cars(inputCarNames);
    }

    private void race() {
        Random random = new Random();
        for (int i = 0; i < cars.count(); i++) {
            Car car = cars.find(i);
            car.move(RacingRule.moveOrStop(random.nextInt(10)));
        }

    }
}
