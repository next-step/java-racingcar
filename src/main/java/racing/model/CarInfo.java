package racing.model;

public class CarInfo {

    private final int position;

    private final String name;

    public CarInfo(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
