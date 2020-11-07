package study.racingcar.view;

import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.racingcars.RacingCarsSnapshot;

import java.util.List;

public class ResultView {

    private static final ResultView instance = new ResultView();

    public static ResultView getInstance() {
        return instance;
    }

    private ResultView() {}

    public void displayCurrentStatus(RacingCarsSnapshot racingCarsSnapshot) {
        for (CarSnapshot carSnapshot : racingCarsSnapshot.getCarSnapshot()) {
            displayCar(carSnapshot);
        }
        // 각각의 시도가 끝나면 개행
        System.out.println();

    }

    private void displayCar(CarSnapshot carSnapshot) {
        for (int position = 0; position < carSnapshot.getCurrentPosition(); position++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
