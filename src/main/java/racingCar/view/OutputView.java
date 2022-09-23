package racingCar.view;

import racingCar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RACING_RESULT = "실행 결과";

    public void printRacingResultTitle(){
        System.out.println(RACING_RESULT);
    }
    public void showRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.showDistance());

        }
        System.out.println();
    }
}
