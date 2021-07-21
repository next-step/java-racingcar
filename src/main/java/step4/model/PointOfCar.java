package step4.model;

public class PointOfCar{
    private final String name;
    private final int point;

    public PointOfCar(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
}
