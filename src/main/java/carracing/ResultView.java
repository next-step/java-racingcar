package carracing;

import java.util.Map;

public class ResultView {
    private static final String CAR_MOVESTATUS_DASH = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printCarRacingResult(CarsMoveStatusHistory carsMoveStatusHistory) {
        StringBuilder stringBuilder = new StringBuilder("실행 결과").append(NEW_LINE);

        for (int i = 0; i < carsMoveStatusHistory.getCarsMoveStatusHistory().size(); i++) {
            stringBuilder.append(createResultByAMoveTryCount(carsMoveStatusHistory.getCarsMoveStatusHistoryByMoveTryCount(i)))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder createResultByAMoveTryCount(Map<Car, CarPosition> carsMoveStatusHistoryByTryCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CarPosition position : carsMoveStatusHistoryByTryCount.values()) {
            stringBuilder
                    .append(createDashBy(position))
                    .append(NEW_LINE);
        }
        return stringBuilder;
    }

    private static String createDashBy(CarPosition position) {
        return CAR_MOVESTATUS_DASH.repeat(position.getMax(0));
    }

}
