package study.nextstep.stage5.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class GameStatus {
    private ArrayList<Position> status;
    private int remainingTotalTurn;

    public GameStatus(int size, int totalTurn){
        status = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            status.add(new Position());
        }
        remainingTotalTurn = totalTurn;
    }

    public boolean totalTurn(Random randomModule) {
        if (remainingTotalTurn <= 0) {
            return false;
        }

        for (Position stat : status) {
            stat.run(randomModule);
        }
        remainingTotalTurn--;
        return true;
    }

    public Position getPosition(int pos) {
        if (pos >= status.size()) {
            throw new IllegalArgumentException();
        }
        return status.get(pos);
    }

    public ArrayList<Integer> getWinnerPosition() {
        if (remainingTotalTurn > 0) {
            throw new IllegalArgumentException();
        }

        int winnerMove = 0;
        for (Position stat : status) {
            if (winnerMove < stat.getValue()) {
                winnerMove = stat.getValue();
            }
        }

        ArrayList<Integer> winnerIndexes = new ArrayList<>();
        for (int i = 0; i < status.size(); i++) {
            if (status.get(i).getValue() == winnerMove) {
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
