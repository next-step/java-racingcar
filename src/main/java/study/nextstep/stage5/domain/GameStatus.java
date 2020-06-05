package study.nextstep.stage5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameStatus {
    private List<Position> status;
    private int remainingTotalTurn;

    public GameStatus(int size, int totalTurn){
        if (size <= 0) {
            throw new IllegalArgumentException("인원수가 잘못되었습니다");
        }
        if (totalTurn <= 0) {
            throw new IllegalArgumentException("게임 진행 회수가 부족합니다");
        }

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
        if (pos < 0 || status.size() <= pos) {
            throw new IllegalArgumentException("사람 번호를 벗어났습니다");
        }
        return status.get(pos);
    }

    public ArrayList<Integer> getWinnerPosition() {
        if (remainingTotalTurn > 0) {
            throw new IllegalArgumentException("아직 게임이 끝나지 않았습니다");
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
