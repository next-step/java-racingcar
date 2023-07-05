package car.domain;

public final class CarResult {

    private CarName name;
    private String positionMark;

    public CarResult(Car car) {
        this.name = new CarName(car.getName());
        this.positionMark = createPositionMark(car.getPosition());
    }

    private String createPositionMark(int position) {
        return "-".repeat(position);
    }

    @Override
    public String toString() {
        return name.getName() + " : " + positionMark;
    }
}
