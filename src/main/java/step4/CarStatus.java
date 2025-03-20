package step4;

public class CarStatus {
    private final String name;
    private final int position;

    public CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
