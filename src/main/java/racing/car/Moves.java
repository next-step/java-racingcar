package racing.car;

import java.util.List;
import java.util.Objects;

public class Moves {
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

    public boolean getMove(int round) {
        return this.moves.get(round);
    }

    public int getDistance() {
        return (int) this.moves.stream()
                .filter(item -> item)
                .count();
    }

    public int getTotalMovesCount() {
        return this.moves.size();
    }
}
