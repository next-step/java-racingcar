package racing.model;

public class Car {

    private int position;
    private String name;

    private Car(String name) {
        this.name = name;
    }

    public Car of(String name) {
        return new Car(name);
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
