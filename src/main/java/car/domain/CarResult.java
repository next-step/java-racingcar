package car.domain;

public final class CarResult {

    private final String name;
    private final int position;

    public CarResult(final Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
