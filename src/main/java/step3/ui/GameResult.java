package step3.ui;

import step3.domain.board.CarSnapShots;
import step3.domain.board.CarSnapshot;
import step3.domain.board.GameBoard;
import step3.domain.car.Name;
import step3.domain.car.Winners;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameResult {

    private static final char TRACE = '-';
    private static final int STRING_BUILDER_CLEAR_VALUE = 0;
    private static final StringBuilder stringBuilder = new StringBuilder();

    private final List<CarSnapShots> carSnapShots;
    private final Winners winners;

    public GameResult(GameBoard gameBoard, Winners winners) {
        checkArgument(gameBoard != null, "gameBoard is required");
        checkArgument(winners != null, "winners is required");
        this.carSnapShots = gameBoard.getCarSnapShots();
        this.winners = winners;
    }

    public void showGame() {
        System.out.println("\n실행결과");
        for (CarSnapShots carSnapShots : this.carSnapShots) {
            showRound(carSnapShots);
            System.out.println();
        }
        showWinners();
    }

    private void showRound(CarSnapShots carSnapShots) {
        for (CarSnapshot snapshot : carSnapShots.getCarSnapshots()) {
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
        for (Name name : winners.getWinnersName()) {
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
