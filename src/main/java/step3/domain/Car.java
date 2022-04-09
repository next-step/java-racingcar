package step3.domain;

public class Car {

    public static final int DEFAULT_POSITION = 1;
    private int position;

    public Car() {
        position = DEFAULT_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void proceed() {
        ++position;
    }

    public void proceedWithPolicy(ProceedPolicy proceedPolicy) {
        if (proceedPolicy.canMoveForward(this)) {
            ++position;
        }
    }
}
