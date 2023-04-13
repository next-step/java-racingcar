package racing;

public class Car {
    public int moveStatus;

    public void move(int moveCount) {
        moveStatus += moveCount;
    }
}
