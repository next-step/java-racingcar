package view;

import model.Position;

public class ResultView {

    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_POSITION = "-";

    private ResultView() {

    }

    public static ResultView getInstance() {
        return new ResultView();
    }

    public void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public void printLineBreak() {
        System.out.println();
    }

    public void printPosition(Position position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append(PRINT_POSITION);
        }

        System.out.print(stringBuilder);

        printLineBreak();
    }
}
