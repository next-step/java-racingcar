package step3.domain;

public class Car {

    private static final int THRESHOLD = 4;
    private int forwardCount = 0;

    public void move(int randomNumber) {
        if (isImmovable(randomNumber)) {
            return;
        }
        this.forwardCount++;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    private boolean isImmovable(int number) {
        return number < THRESHOLD;
    }
}
