package racing.domain;

public class CarHistory {

    private final String name;
    private final int position;

    public CarHistory(String name, int position) {
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
