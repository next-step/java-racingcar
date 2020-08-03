package step3.domain;

public class Car implements Cloneable {

    private final ForwardStrategy forwardStrategy;
    private int position = 1;

    public Car(ForwardStrategy forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
    }

    public Car move() {
        position += forwardStrategy.calculateForwardDistance();
        return this;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Car(null);
        }
    }

}
