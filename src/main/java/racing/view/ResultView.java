package racing.view;

public class ResultView {
    private static final String RACING_CAR_GAME_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_POSITION_MARK = "-";

    public void printRacingCarGameResultOutputMessage() {
        System.out.println(RACING_CAR_GAME_RESULT_OUTPUT_MESSAGE);
    }

    public void printRacingCarsPosition(int[] racingCarPositions) {
        for (int position : racingCarPositions) {
            printRacingCarPositionMark(position);
        }
        printNewLine();
    }

    private void printRacingCarPositionMark(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(RACING_CAR_POSITION_MARK);
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }
}
