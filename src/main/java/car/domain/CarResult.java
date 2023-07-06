package car.domain;

public final class CarResult {

    private final CarName name;
    private final String positionMark;

    public CarResult(final Car car) {
        this.name = new CarName(car.getName());
        this.positionMark = createPositionMark(car.getPosition());
    }

    private String createPositionMark(final int position) {
        return "-".repeat(position);
    }

    @Override
    public String toString() {
        return name.getName() + " : " + positionMark;
    }
}
