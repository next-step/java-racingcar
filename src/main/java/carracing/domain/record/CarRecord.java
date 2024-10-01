package carracing.domain.record;

import carracing.domain.Car;

public class CarRecord {
    private final String name;
    private int position;

    private CarRecord(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarRecord of(String name, int position) {
        return new CarRecord(name, position);
    }

    public static CarRecord of(Car car) {
        return CarRecord.of(car.getName(), car.getPosition());
    }

    public boolean isPositionEqualTo(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
