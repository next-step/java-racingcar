package step3.racingcar;

import java.util.List;

public class ResultViewProcessor {

    private static final String POSITION_MARK = "-";

    private ResultViewProcessor() {
    }

    public static void printResult(GameResultBoard gameResultBoard) {
        System.out.println(Message.RESULT_HEADER);
        int[][] parsedGameResultBoard = gameResultBoard.getGameResultBoard();
        String[] carNames = gameResultBoard.getCarNames();
        int column = parsedGameResultBoard[0].length;
        for (int i = 0; i < column; i++) {
           // printCurrentPosition(row, i, parsedGameResultBoard, carNames);
        }
        System.out.println();
    }

    private static void printCurrentPosition(int row, int column, int[][] board, String[] carNames) {
        for (int i = 0; i < row; i++) {
            System.out.println(carNames[i] + " : " + board[row][column]);
        }
        System.out.println();
    }
}
