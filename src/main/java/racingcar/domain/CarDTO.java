package racingcar.domain;

public class CarDTO {
    private Name name;
    private Position position;

    public CarDTO(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
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
}
