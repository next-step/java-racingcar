package racingcar.dto;

public class CarRecord {
    private final int position;
    private final String name;

    public CarRecord(String name, int position) {
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
