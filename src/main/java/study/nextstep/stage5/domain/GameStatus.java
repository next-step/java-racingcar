package study.nextstep.stage5.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameStatus implements Iterable<Position>{
    private List<Position> status;
    private int remainingTotalTurn;

    public GameStatus(String[] names, int totalTurn){
        if (names == null || names.length <= 0) {
            throw new IllegalArgumentException("인원수가 잘못되었습니다");
        }
        if (totalTurn <= 0) {
            throw new IllegalArgumentException("게임 진행 회수가 부족합니다");
        }

        status = new ArrayList<>();
        for (String name : names) {
            status.add(new Position(name));
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

    public ArrayList<Position> getWinnerPosition() {
        if (remainingTotalTurn > 0) {
            throw new IllegalArgumentException("아직 게임이 끝나지 않았습니다");
        }

        Position winner = null;
        for (Position stat : status) {
            winner = stat.compareWinner(winner);
        }

        ArrayList<Position> winnerIndexes = new ArrayList<>();
        for (Position stat : status) {
            if (stat.isWinner(winner)) {
                winnerIndexes.add(stat);
            }
        }
        return winnerIndexes;
    }

    public String getWinnerNames() {
        return getWinnerPosition().stream().map(pos -> pos.getName())
                .collect(Collectors.joining(", "));
    }

    @Override
    public Iterator<Position> iterator() {
        return (Iterator<Position>) status;
    }
}
