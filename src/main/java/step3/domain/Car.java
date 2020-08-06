package step3.domain;

public class Car implements Cloneable {

    private int position = 1;

    public Car move(ForwardStrategy forwardStrategy) {
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
            return new Car();
        }
    }

}
