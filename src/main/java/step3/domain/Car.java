package step3.domain;

public class Car implements Cloneable {

    private final String name;

    private int position = 1;

    public Car(String name) {
        this.name = name;
    }

    public Car move(ForwardStrategy forwardStrategy) {
        position += forwardStrategy.calculateForwardDistance();
        return this;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
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
