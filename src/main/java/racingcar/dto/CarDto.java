package racingcar.dto;

public class CarDto {
    private final int position;
    private final String name;

    public CarDto(String name, int position) {
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
