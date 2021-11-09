package step3.ui;

import step3.domain.board.CarSnapshot;
import step3.domain.board.GameBoard;
import step3.domain.board.RoundBoard;

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
        for (CarSnapshot snapshot : roundBoard.getRecords()) {
            System.out.print(snapshot.getName() + " : ");
            print(snapshot.getLocation());
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
