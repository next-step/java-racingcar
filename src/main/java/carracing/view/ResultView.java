package carracing.view;

import carracing.domain.carracing.CarsMoveStatusHistory;
import carracing.domain.carracing.Car;
import carracing.domain.carracing.Cars;
import carracing.domain.carracing.Position;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    private static final String CAR_MOVESTATUS_DASH = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printCarRacingResult(CarsMoveStatusHistory carsMoveStatusHistory) {
        StringBuilder stringBuilder = new StringBuilder("실행 결과").append(NEW_LINE);

        for (int i = 0; i < carsMoveStatusHistory.numberOfMoveTryCount(); i++) {
            stringBuilder
                    .append(createResultByAMoveTryCount(carsMoveStatusHistory.carsBy(i)))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder createResultByAMoveTryCount(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.get()) {
            stringBuilder
                    .append(car.getNameString()).append(COLON)
                    .append(createDashBy(car.getPosition()))
                    .append(NEW_LINE);
        }
        return stringBuilder;
    }

    private static String createDashBy(Position position) {
        return CAR_MOVESTATUS_DASH.repeat(position.compareMax(0));
    }

    public static void printCarRacingWinners(List<String> winnersNames) {
        StringJoiner stringJoiner = new StringJoiner(COMMA);
        for (String winnerName : winnersNames) {
            stringJoiner.add(winnerName);
        }
        System.out.println(stringJoiner + "가 최종 우승했습니다.");
    }
}
