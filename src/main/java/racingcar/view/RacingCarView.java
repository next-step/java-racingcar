package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarView {

    private static final String DASH = "-";
    private static final String ENTER = "\n";
    private static final String COMMA = ",";
    private static final String RACING_RESULT_VIEW = "실행결과" + ENTER;
    private static final String RACING_VIEW = "%s : %s" + ENTER;
    private static final String WINNER_VIEW = "최종 우승자: ";

    private RacingCarView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRacing(List<Cars> racingLog) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RACING_RESULT_VIEW);
        for (Cars cars : racingLog) {
            String log = convertCarsToRacingRog(cars);
            stringBuilder.append(log)
                .append(ENTER);
        }
        System.out.println(stringBuilder);
    }

    private static String convertCarsToRacingRog(Cars cars) {
        return cars.getCars().stream()
            .map(car -> String.format(RACING_VIEW, car.getName(), convertPositiontoDash(car)))
            .collect(Collectors.joining());
    }

    private static String convertPositiontoDash(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DASH);
        }
        return stringBuilder.toString();
    }

    public static void printWinner(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNER_VIEW);
        String winners = cars.caculateWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(COMMA));
        stringBuilder.append(winners);
        System.out.println(stringBuilder);
    }
}
