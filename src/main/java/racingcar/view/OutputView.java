package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String CAR_COUNT_EXCEPTIONM_ESSAGE = "자동차 생성 숫자는 0 이상 입력";
    private static final String TRY_COUNT_EXCEPTIONM_ESSAGE = "시도할 회수는 0 이상 입력";
    private static final String MOVE_SYMBOL = "-";

    private OutputView() {
    }

    public static void printCarCountExceptionMessage() {
        System.out.println(CAR_COUNT_EXCEPTIONM_ESSAGE);
    }

    public static void printTryCountExceptionMessage() {
        System.out.println(TRY_COUNT_EXCEPTIONM_ESSAGE);
    }

    public static void printResult(Cars cars) {
        cars.getCars().forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        for (int i = 0; i < car.positionValue(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }
}
