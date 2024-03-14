package race.domain;

public class Car {

    private int position;
    private final String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void go() {
            this.position++;
    }

}
