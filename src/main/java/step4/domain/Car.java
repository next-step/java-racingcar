package step4.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = INITIAL_POSITION;
    }
}
