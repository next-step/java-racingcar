package racingcar.model;

public class CarInformation {
    private String name;
    private Position position;

    public CarInformation(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public CarInformation(String name) {
        new CarInformation(name, Position.valueOf(0));
    }

    public Position increasePosition() {
        position = Position.add(position, Position.valueOf(1));
        return position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
