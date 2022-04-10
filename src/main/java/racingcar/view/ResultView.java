package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행결과";

    public static void renderResultView(List<Car> cars, int tryCount) {
        if (isFirstResult(tryCount)) {
            System.out.println(MESSAGE_RESULT);
        }
        for (Car car : cars) {
            System.out.println(car.getPositionView());
        }
        System.out.println("");
    }

    private static boolean isFirstResult(int tryCount) {
        return tryCount == 0;
    }
}
