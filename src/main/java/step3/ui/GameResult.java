package step3.ui;

import step3.domain.board.GameBoard;
import step3.domain.board.RoundBoard;
import step3.domain.car.Location;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameResult {

    private final static char TRACE = '-';
    private final static StringBuilder stringBuilder = new StringBuilder();

    private final List<RoundBoard> roundBoards;

    public GameResult(GameBoard gameBoard) {
        checkArgument(gameBoard != null, "gameBoard is required");
        roundBoards = gameBoard.getRoundBoards();
    }

    public void showGame() {
        System.out.println("\n실행결과");
        for (RoundBoard roundBoard : roundBoards) {
            showRound(roundBoard);
            System.out.println();
        }
    }

    public void showRound(RoundBoard roundBoard) {
        for (Location location : roundBoard.getRecords()) {
            print(location.getLocation());
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
