package racingcar.model;

public class CarInformation {
    private String name;
    private Position position;

    public CarInformation(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public CarInformation(String name) {
        this(name, Position.valueOf(0));
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
