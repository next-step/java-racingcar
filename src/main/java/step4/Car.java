package step4;

public class Car {
    public String name;
    public int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.location += 1;
    }
}
