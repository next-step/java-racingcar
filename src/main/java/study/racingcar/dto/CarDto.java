package study.racingcar.dto;

public class CarDto {
    private String name;
    private int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
