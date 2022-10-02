package racing;

public class Car {
    private int moves = 0;

    public void move() {
        moves += 1;
    }

    public int getMoves() {
        return moves;
    }
}
