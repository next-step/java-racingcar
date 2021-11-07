package race;

public class Car {
    private int location = 0;

    public void move() {
        location++;
    }

    public int location() {
        return location;
    }
}
