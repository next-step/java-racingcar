package racinggame.vo;

public class Car {

    private final int number;

    private final String name;

    private int moveCount = 0;

    public Car(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void move() {
        moveCount++;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
