package racing.car;

import java.util.List;

public class Moves {
    private final List<Boolean> moves;

    public Moves(List<Boolean> moves) {
        this.moves = moves;
    }

    public List<Boolean> getMoves() {
        return moves;
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

    public int howToMoves() {
        return this.moves.size();
    }
}
