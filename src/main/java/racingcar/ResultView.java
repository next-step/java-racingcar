package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(List<List<String>> carsPositionPerRound) {
        printResultTitle();
        carsPositionPerRound.forEach(ResultView::printCarPositionOfRound);
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPositionOfRound(List<String> roundResult) {
        roundResult.forEach(ResultView::printPositionDrawing);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printPositionDrawing(String posDrawing) {
        System.out.println(posDrawing);
    }

}
