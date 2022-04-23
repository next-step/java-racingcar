package view;

import model.CarName;
import model.Position;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_POSITION = "-";
    private static final String CAR_NAME_POSITION_SEPARATOR = " : ";
    private static final String CAR_NAME_COLLECTORS_JOINING = ", ";
    private static final String WINNER_CAR_NAME_APPEND_TEXT = "가 최종 우승했습니다.";


    public static void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printExecuteResult(CarName carName, Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName.getName());
        stringBuilder.append(CAR_NAME_POSITION_SEPARATOR);
        stringBuilder.append(printPosition(position));
        System.out.println(stringBuilder.toString());
    }

    private static String printPosition(Position position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append(PRINT_POSITION);
        }

        return stringBuilder.toString();
    }

    public static void printWinnerCars(List<CarName> carNames) {
        StringBuilder stringBuilder = new StringBuilder();
        String winnerCarNames = carNames.stream().map(CarName::getName).collect(Collectors.joining(CAR_NAME_COLLECTORS_JOINING));
        stringBuilder.append(winnerCarNames);
        stringBuilder.append(WINNER_CAR_NAME_APPEND_TEXT);
        System.out.println(stringBuilder);
    }
}
