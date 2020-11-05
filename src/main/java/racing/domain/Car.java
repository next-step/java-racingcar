package racing.domain;

public class Car {

    private final String name;

    private int displacement = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        displacement++;
    }

    public String getName() {
        return name;
    }

    public int getDisplacement() {
        return displacement;
    }
}
