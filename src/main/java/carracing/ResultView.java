package carracing;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ResultView {
    private static final String CAR_MOVESTATUS_DASH = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printCarRacingResult(CarsMoveStatusHistory carsMoveStatusHistory) {
        StringBuilder stringBuilder = new StringBuilder("실행 결과").append(NEW_LINE);

        for (int i = 0; i < carsMoveStatusHistory.getCarsMoveStatusHistory().size(); i++) {
            stringBuilder
                    .append(createResultByAMoveTryCount(carsMoveStatusHistory.getCarsMoveStatusHistoryByMoveTryCount(i)))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder createResultByAMoveTryCount(Map<Car, CarPosition> carsMoveStatusHistoryByTryCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Car, CarPosition> carMoveStatusHistoryByTryCount : carsMoveStatusHistoryByTryCount.entrySet()) {
            stringBuilder
                    .append(carMoveStatusHistoryByTryCount.getKey().getCarNameString())
                    .append(COLON)
                    .append(createDashBy(carMoveStatusHistoryByTryCount.getValue()))
                    .append(NEW_LINE);
        }
        return stringBuilder;
    }

    private static String createDashBy(CarPosition position) {
        return CAR_MOVESTATUS_DASH.repeat(position.getMax(0));
    }

    public static void printCarRacingWinners(List<String> winnersNames) {
        StringJoiner stringJoiner = new StringJoiner(COMMA);
        for(String winnerName : winnersNames) {
            stringJoiner.add(winnerName);
        }
        System.out.println(stringJoiner + "가 최종 우승했습니다.");
    }
}
