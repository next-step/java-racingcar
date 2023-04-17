package racing;

public class Car {
    private int location = 0;
    private static final int MOVE_CONDITION = 4;

    public void move(int condition) {
        if (this.isMove(condition)) {
            this.location += 1;
        }
    }

    private boolean isMove(int condition) {
        return condition >= MOVE_CONDITION;
    }

    public int getCurrentLocation() {
        return this.location;
    }
}