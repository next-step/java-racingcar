package racing;

public class RacingInput {

    private final int carSize;
    private final int moves;

    public RacingInput(int carSize, int moves) {
        this.carSize = carSize;
        this.moves = moves;
    }

    public int getCarSize() {
        return carSize;
    }

    public int getMoves() {
        return moves;
    }
}
