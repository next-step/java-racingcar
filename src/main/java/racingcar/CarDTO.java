package racingcar;

public class CarDTO {
    private String name;
    private int position;

    CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    boolean isPositionOf(int position) {
        return this.position == position;
    }
}