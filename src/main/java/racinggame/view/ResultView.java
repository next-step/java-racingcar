package racinggame.view;

import static java.lang.System.out;

import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.Cars;

public class ResultView {

    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String COMMA_AND_BLANK = ", ";
    private static final int LAST_CHECK_NUMBER = 1;
    private static final String RESULT_SIGN = "실행 결과";
    private static final String WINNER_POSTFIX = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void br() {
        out.println();
    }

    public static void resultSign() {
        out.println(RESULT_SIGN);
    }

    public static void report(Cars cars) {
        for (Car car : cars.findAll()) {
            printResult(car);
        }
        br();
    }

    private static void printResult(Car car) {
        printCarName(car);
        printDistance(car);
    }

    private static void printDistance(Car car) {
        out.println(DASH.repeat(Math.max(0, car.movingDistance().distance())));
    }

    private static void printCarName(Car car) {
        out.print(car.toStringName() + COLON);
    }

    public static void winners(Cars winners) {
        List<CarName> names = winners.names();
        out.println(toStringWinner(names) + WINNER_POSTFIX);
    }

    private static String toStringWinner(List<CarName> names) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).toString();
            message.append(name);
            applyComma(names, message, i);
        }

        return message.toString();
    }

    private static void applyComma(List<CarName> names, StringBuilder message, int i) {
        if (isEndOfWinner(names, i)) {
            message.append(COMMA_AND_BLANK);
        }
    }

    private static boolean isEndOfWinner(List<CarName> names, int i) {
        return i < names.size() - LAST_CHECK_NUMBER;
    }

}
