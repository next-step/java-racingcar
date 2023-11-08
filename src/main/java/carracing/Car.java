package carracing;

public class Car {

    private static final int START_POSITION = 1;

    private CarName name;
    private Integer position;

    public Car(String name) {
        this.name = CarName.from(name);
        this.position = START_POSITION;
    }

    public String getName() {
        return this.name.getName();
    }

    public Integer getPosition() {
        return this.position;
    }

    public void move(int i) {
        position += i;
    }
}
