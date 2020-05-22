package racing;

public class Car {
    private CarMoveBehavior carMoveBehavior;
    private int position;

    public Car(CarMoveBehavior carMoveBehavior) {
        this.carMoveBehavior = carMoveBehavior;
    }

    public void move() {
        if (carMoveBehavior.action()) {
            position++;
        }
    }
}
