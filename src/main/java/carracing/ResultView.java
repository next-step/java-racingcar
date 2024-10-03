package carracing;

import java.util.Map;

public class ResultView {
    private static final String CAR_MOVESTATUS_DASH = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printCarRacingResult(CarsMoveStatusHistory carsMoveStatusHistory) {
        StringBuilder stringBuilder = new StringBuilder("실행 결과").append(NEW_LINE);

        for (int i = 0; i < carsMoveStatusHistory.getCarsMoveStatusHistory().size(); i++) {
            stringBuilder.append(createResultOfAMoveTryCount(carsMoveStatusHistory.getCarsMoveStatusHistoryByMoveTryCount(i)))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder createResultOfAMoveTryCount(Map<Car, Integer> carsMoveStatusHistoryByTryCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : carsMoveStatusHistoryByTryCount.values()) {
            stringBuilder
                    .append(createDashBy(integer))
                    .append(NEW_LINE);
        }
        return stringBuilder;
    }

    private static String createDashBy(Integer carMoveStatus) {
        return CAR_MOVESTATUS_DASH.repeat(Math.max(0, carMoveStatus));
    }

}
