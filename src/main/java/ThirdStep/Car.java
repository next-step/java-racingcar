package ThirdStep;

public class Car {
    private int location;

    public Car() {
        this.location = 1;
    }

    public int getLocation() {
        return location;
    }

    public void move(boolean canForward) {
        if (canForward) {
            ++location;
        }
    }

    public void printLocation() {
        System.out.println("-".repeat(location));
    }
}
