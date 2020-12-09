package racing;

public class Car {
    private int moveCount;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.moveCount = 0;
        this.name = name;
    }

    public void move() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }
}
