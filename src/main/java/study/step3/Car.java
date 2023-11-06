package study.step3;

public class Car {

    private int position = 1;

    public Car() {
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (isForwardCondition(randomNumber)) {
            forward();
        }
    }

    private boolean isForwardCondition(int randomNumber) {
        return randomNumber >= 4;
    }

    private void forward() {
        position += 1;
    }

}
