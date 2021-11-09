package step3.ui;

import step3.domain.board.CarSnapshot;
import step3.domain.board.GameBoard;
import step3.domain.board.RoundBoard;
import step3.domain.car.Name;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameResult {

    private static final char TRACE = '-';
    private static final int STRING_BUILDER_CLEAR_VALUE = 0;
    private static final StringBuilder stringBuilder = new StringBuilder();

    private final List<RoundBoard> roundBoards;
    private final List<Name> winnerNames;

    public GameResult(GameBoard gameBoard, List<Name> winnerNames) {
        checkArgument(gameBoard != null, "gameBoard is required");
        checkArgument(winnerNames != null, "winnerNames is required");
        this.roundBoards = gameBoard.getRoundBoards();
        this.winnerNames = winnerNames;
    }

    public void showGame() {
        System.out.println("\n실행결과");
        for (RoundBoard roundBoard : roundBoards) {
            showRound(roundBoard);
            System.out.println();
        }
        showWinners();
    }

    private void showRound(RoundBoard roundBoard) {
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
        clearStringBuilder();
    }

    private void showWinners() {
        for (Name name : winnerNames) {
            String stringName = name.getName();
            stringBuilder.append(stringName).append(",");
        }
        eraseLastComma();
        String stringNames = stringBuilder.toString();
        System.out.println(stringNames + "가 최종 우승했습니다.");
        clearStringBuilder();
    }

    private void eraseLastComma() {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    private void clearStringBuilder() {
        stringBuilder.setLength(STRING_BUILDER_CLEAR_VALUE);
    }
}
