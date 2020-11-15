package racingcar.domain;

public class CarDTO {
    private Name name;
    private Position position;

    public CarDTO(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public CarDTO(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    public String getPosition() {
        return this.position.getPositionString();
    }

    public CarDTO(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }
}
