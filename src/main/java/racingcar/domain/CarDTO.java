package racingcar.domain;

public class CarDTO {
    private String name;
    private int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPositionOf(int position) {
        return this.position == position;
    }
}