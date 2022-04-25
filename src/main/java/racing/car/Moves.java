package racing.car;

import java.util.List;
import java.util.Objects;

public class Moves {
    private static final Integer MOVE = 1;
    private static final Integer NOME_MOVE = 0;
    private static final Integer DISTANCE_INITIALIZE_VALUE = 0;
    private final List<Boolean> moves;

    public Moves(List<Boolean> moves) {
        if (Objects.isNull(moves)) {
            throw new IllegalArgumentException("Moves 초기화 실패하였습니다.");
        }
        this.moves = moves;
    }

    public void addMove(boolean cycle) {
        this.moves.add(cycle);
    }

    public int getRoundDistance(int round) {
        int distance = DISTANCE_INITIALIZE_VALUE;
        for (int i = 0; i < round; i++) {
            distance += addDistance(moves.get(i));
        }
        return distance;
    }

    private int addDistance(Boolean move) {
        if (move) {
            return MOVE;
        }
        return NOME_MOVE;
    }

    public int getDistance() {
        return getRoundDistance(moves.size());
    }

    public int getTotalMovesCount() {
        return this.moves.size();
    }
}
