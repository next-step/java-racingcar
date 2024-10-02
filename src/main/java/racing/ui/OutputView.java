package racing.ui;

import java.util.List;
import racing.model.CarInfo;
import racing.model.RoundResult;
import racing.model.collection.GameResult;

public class OutputView {

    private static final String OUTPUT_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_SUFFIX = "가 최종 우승했습니다.";

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
        printWinners(gameResult.getWinners());
    }

    private static void printResult(RoundResult result) {
        for (CarInfo info : result.getCarInfos()) {
            System.out.println(convertCarInfoToGage(info));
        }
    }

    private static String convertCarInfoToGage(CarInfo info) {
        return info.getName() + " : "
                + "-".repeat(Math.max(0, info.getPosition()));
    }

    private static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames + WINNER_MESSAGE_SUFFIX);
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printStartMessage() {
        System.out.println(OUTPUT_START_MESSAGE);
    }
}
