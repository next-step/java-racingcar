package step4;

public class Car {
    public String name;
    public int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void moveForward() {
        this.location += 1;
    }
}
