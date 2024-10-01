package racing.ui;

import racing.model.CarInfo;
import racing.model.RoundResult;
import racing.model.collection.CarInfoList;
import racing.model.collection.GameResult;

public class OutputView {

    private static final String OUTPUT_START_MESSAGE = "실행 결과";

    public OutputView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static void printGameResults(GameResult gameResult) {
        printBlankLine();
        printStartMessage();
        for (RoundResult result : gameResult.getRoundResults()) {
            printResult(result);
            printBlankLine();
        }
    }

    private static void printResult(RoundResult result) {
        CarInfoList carInfoList = result.getCarInfoList();
        for (CarInfo info : carInfoList.getCarInfos()) {
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
