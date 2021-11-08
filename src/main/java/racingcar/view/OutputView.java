package racingcar.view;

import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

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
        List<Integer> carsPosition = cars.carsPosition();

        for (int position : carsPosition) {
            printPosition(position);
            newLine();
        }
        newLine();
    }

    private static void printPosition(int positionCount) {
        IntStream.rangeClosed(1, positionCount)
                .mapToObj(value -> MOVE_SYMBOL)
                .forEach(System.out::print);
    }


    private static void newLine() {
        System.out.println();
    }
}
