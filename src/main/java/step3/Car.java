package step3;

public class Car {
    private int location = 0;

    public int getLocation() { return location; }

    public void progress() { this.location += 1; }
}
