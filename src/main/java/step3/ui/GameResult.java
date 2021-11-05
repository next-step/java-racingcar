package step3.ui;

import step3.domain.board.GameBoard;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameResult {

    private final static char TRACE = '-';
    private final static StringBuilder stringBuilder = new StringBuilder();

    private final List<List<Integer>> records;

    public GameResult(GameBoard gameBoard) {
        checkArgument(gameBoard != null, "gameBoard is required");
        records = gameBoard.readAllRecords();
    }

    public void showGame() {
        System.out.println("\n실행결과");
        for (List<Integer> record : records) {
            showRound(record);
            System.out.println();
        }
    }

    public void showRound(List<Integer> records) {
        for (Integer record : records) {
            print(record);
        }
    }

    private void print(int count) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(TRACE);
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}
