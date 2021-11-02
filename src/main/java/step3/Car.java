package step3;

public class Car {
    private Long position = 0L;

    public Car() {
    }

    public Long getPosition() {
        return position;
    }

    public void moveOrStop(int rand) {
        if (isGo(rand)) {
            move();
        }
    }

    private void move() {
        this.position++;
    }

    private boolean isGo(int rand) {
        return rand >= 4;
    }
}
