package study.step4;

public class Car {

    private static final int MOVE_SIGN = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        this.position++;
    }

    public boolean canMove(int num) {
        return num >= MOVE_SIGN;
    }

}
