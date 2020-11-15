package racing.model;

public class RacingCar implements Car {

    private static final int MOVEABLE_NUMBER = 4;

    private Name name;
    private Position position = new Position();

    public RacingCar(String name) {
        this.name = new Name(name);
    }

    @Override
    public void move(int fuel) {
        if (MOVEABLE_NUMBER <= fuel) {
            position.increase();
        }
    }

    @Override
    public int currentLocation() {
        return position.getPosition();
    }

    public String getCarName() {
        return name.getName();
    }
}
