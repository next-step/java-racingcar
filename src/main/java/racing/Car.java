package racing;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public void init() {
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
