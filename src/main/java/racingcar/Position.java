package racingcar;

public class Position {

    private int moveCount;

    public int getMoveCount() {
        return moveCount;
    }

    public void increase() {
        this.moveCount++;
    }

    public Position(int moveCount) {
        this.moveCount = moveCount;
    }

}
