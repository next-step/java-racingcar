public class Car {
    private int position = 1;
    private final MovePolicy movePolicy;

    public Car(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void move() {
        if (this.movePolicy.isAbleToMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
