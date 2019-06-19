package racingcar.model;

public class CarPosition {
    private String name;
    private Integer position;

    public CarPosition(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}


