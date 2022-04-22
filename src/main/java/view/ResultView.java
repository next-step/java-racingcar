package view;

import model.CarName;
import model.Position;

public class ResultView {

    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_POSITION = "-";
    private static final String CAR_NAME_POSITION_SEPARATOR = " : ";


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
}
