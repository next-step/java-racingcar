package step3;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public boolean isMove(int randomValue, int limit) {
        return randomValue >= limit;
    }

    public int getPosition() {
        return this.position;
    }
}
