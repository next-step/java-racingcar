package study.step3;

public class Car {

    private static final int MOVE_SIGN = 4;
    private int position;

    Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    public boolean canMove(int min, int max) {
        int num = (int) (Math.random() * (max - min + 1) + min);
        return num >= MOVE_SIGN;
    }

}
