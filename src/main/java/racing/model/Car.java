package racing.model;

public class Car implements Cloneable {

    private String name;
    private int criterion;
    private int position;

    public Car(String name) {
        this.name = name;
        this.criterion = 4;
        this.position = 1;
    }

    public Car(String name, int criterion) {
        this.name = name;
        this.criterion = criterion;
        this.position = 1;
    }

    private Car(Car original) {
        this.name = original.name;
        this.criterion = original.criterion;
        this.position = original.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOneStepMoreThanCriterion(int value) {
        if (value >= this.criterion) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Car(this);
        }
    }

}
