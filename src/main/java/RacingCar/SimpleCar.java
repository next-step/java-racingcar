package RacingCar;

public class SimpleCar implements Car {
    private String name;
    private int distance = 0;

    public SimpleCar(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int forward() {
        return ++distance;
    }
}
