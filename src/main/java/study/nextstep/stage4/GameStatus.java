package study.nextstep.stage4;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class GameStatus {
    private static final int THRESHOLD_CAR_MOVE_RANDOM_VAL = 4;
    private static final int CAR_MOVE_RANDOM_LIMIT_VAL = 10;

    private ArrayList<Integer> status;
    private int remainingTotalTurn;

    public GameStatus(int size, int totalTurn){
        status = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            status.add(1);
        }
        remainingTotalTurn = totalTurn;
    }

    private void positionMove(int pos, Random randomModule) {
        if (pos >= status.size()) {
            throw new IllegalArgumentException();
        }

        if (randomModule.nextInt(CAR_MOVE_RANDOM_LIMIT_VAL) >= THRESHOLD_CAR_MOVE_RANDOM_VAL) {
            status.set(pos, status.get(pos) + 1);
        }
    }

    public boolean totalTurn(Random randomModule) {
        if (remainingTotalTurn <= 0) {
            return false;
        }

        for (int i = 0; i < status.size(); i++) {
            positionMove(i, randomModule);
        }
        remainingTotalTurn--;
        return true;
    }

    public int getPosition(int pos) {
        if (pos >= status.size()) {
            throw new IllegalArgumentException();
        }
        return status.get(pos);
    }

    public ArrayList<Integer> getWinnerPosition() {
        int winnerMove = 0;
        for (int stat : status) {
            if (winnerMove < stat) {
                winnerMove = stat;
            }
        }

        ArrayList<Integer> winnerIndexes = new ArrayList<>();
        for (int i = 0; i < status.size(); i++) {
            if (status.get(i) == winnerMove) {
                winnerIndexes.add(i);
            }
        }
        return winnerIndexes;
    }

    public String getWinnerNames(String[] names) {
        return getWinnerPosition().stream().map(pos -> names[pos])
                .collect(Collectors.joining(", "));
    }
}
