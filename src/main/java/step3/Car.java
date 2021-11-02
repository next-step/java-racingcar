package step3;

public class Car {
    private Long now = 0L;

    public Car() {
    }

    public Long getNow() {
        return now;
    }

    public void moveOrStop(int rand) {
        if (isGo(rand)) {
            move();
        }
    }

    private void move() {
        this.now++;
    }

    private boolean isGo(int rand) {
        return rand >= 4;
    }
}
