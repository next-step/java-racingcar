package racingcar.controller;

public class CarStatusDto {

    private final int position;
    private final String name;

    public CarStatusDto(int position, String name) {
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
