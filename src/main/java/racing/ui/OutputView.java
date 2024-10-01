package racing.ui;

import java.util.List;
import racing.domain.RoundResult;
import racing.model.CarInfo;

public class OutputView {

    private static final String OUTPUT_START_MESSAGE = "실행 결과";

    public OutputView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static void printGameResults(List<RoundResult> results) {
        printBlankLine();
        printStartMessage();
        for (RoundResult result : results) {
            printResult(result);
            printBlankLine();
        }
    }

    private static void printResult(RoundResult result) {
        for (CarInfo info : result.getCarInfoList()) {
            System.out.println(convertCarInfoToGage(info));
        }
    }

    private static String convertCarInfoToGage(CarInfo info) {
        return info.getName() + " : "
                + "-".repeat(Math.max(0, info.getPosition()));
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printStartMessage() {
        System.out.println(OUTPUT_START_MESSAGE);
    }
}
