package step3.domain;

public class Car implements Cloneable {

    private final String name;

    private int position = 1;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public Car move(ForwardStrategy forwardStrategy) {
        position += forwardStrategy.calculateForwardDistance();
        return this;
    }

    public boolean checkPosition(int position) {
        return this.position == position;
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
