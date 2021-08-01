package carracing;

public class Car {
    private String location;

    public Car() {
        this.location = "";
    }

    public String location() {
        return location;
    }

    public void forward() {
        this.location += "-";
    }

    public void ordered(int cmd) {
        if (cmd >= 4) {
            forward();
        }
    }
}
