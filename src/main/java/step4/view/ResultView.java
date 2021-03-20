package step4.view;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String POSITION_MESSAGE = "%s : %s";
    private static final String POSITION_CHARACTER = "-";
    private static final String WINNERS_MESSAGE = "%s가 최종 우승 했습니다.";
    private static final String WINNER_SEPARATOR = ", ";

    public static void printResultStartMessage() {
        System.out.println("");
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printPosition(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(getPositionString(car));
        }
        System.out.println("");
    }

    private static String getPositionString(final Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_CHARACTER);
        }
        return String.format(POSITION_MESSAGE, car.getName(), builder.toString());
    }

    public static void printWinners(final Cars cars) {
        List<String> winners = cars.getWinnerNames();
        System.out.println(String.format(WINNERS_MESSAGE, String.join(WINNER_SEPARATOR, winners)));
    }
}
