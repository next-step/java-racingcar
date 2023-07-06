package racing.model;

public class Car {
    private int position = 1;
    private CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void goForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getName();
    }
}
