package racingcar.view;

import racingcar.dto.CarResultDto;

import java.util.List;
import java.util.function.Consumer;

public class ResultView {
    private static final String RESULT_DELIMITER = "-";
    private static final String NAME_DELIMITER = " : ";

    public static void printGameResult(List<List<CarResultDto>> gameResult) {
        printResultComment();
        gameResult.forEach(printRoundResult());
    }

    private static Consumer<List<CarResultDto>> printRoundResult() {
        return eachRound -> {
            eachRound.forEach(printCarResult());
            System.out.println();
        };
    }

    private static Consumer<CarResultDto> printCarResult() {
        return carResult -> {
            printDelimitedResult(carResult.position, carResult.name);
            System.out.println();
        };
    }

    private static void printDelimitedResult(Integer position, String name) {
        System.out.print(name);
        System.out.print(NAME_DELIMITER);
        for (int i = 0; i < position; i++) {
            System.out.print(RESULT_DELIMITER);
        }
    }

    private static void printResultComment() {
        System.out.println("실행 결과");
    }
}
