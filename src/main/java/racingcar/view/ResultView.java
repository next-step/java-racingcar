package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final char MOVE_SYMBOL = '-';

    private ResultView() {}

    public static void printResultStatement() {
        System.out.println("실행 결과");
    }

    public static void printState(List<CarDto> carDtos) {
        carDtos.stream()
                .mapToInt(CarDto::getPosition)
                .forEach(ResultView::printCarMovement);

        printNewLine();
    }

    private static void printCarMovement(int position) {
        IntStream.rangeClosed(0, position)
                .forEach(x -> System.out.print(MOVE_SYMBOL));

        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
