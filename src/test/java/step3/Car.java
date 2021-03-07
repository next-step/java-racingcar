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
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMove(int randomValue) {
        return randomValue >= 4;
    }
}
