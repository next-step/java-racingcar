package step3;

public class Car {
    private int location = 0;

    public Car() {
    }

    public void move(int condition) {
        if (this.isMove(condition)) {
            this.location += 1;
        }
    }

    private boolean isMove(int condition) {
        return condition >= 4;
    }

    public int currentLocation() {
        return this.location;
    }
}