package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행결과";
    private static final int FIRST_TRY = 1;

    public static void renderResultView(List<Car> cars, int tryCount) {
        if (isFirstResult(tryCount)) {
            System.out.println(MESSAGE_RESULT);
        }
        renderResult(cars, tryCount);
    }

    private static void renderResult(List<Car> cars, int tryCount) {
        for (Car car : cars) {
            System.out.println(car.getPositionView());
        }
        System.out.println("[ROUND " + tryCount + " END]");
    }

    private static boolean isFirstResult(int tryCount) {
        return tryCount == FIRST_TRY;
    }
}
