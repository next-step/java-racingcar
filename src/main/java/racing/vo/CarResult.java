package racing.vo;

public class CarResult implements Comparable<CarResult> {

    private final String name;
    private final int distance;

    public CarResult(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(CarResult o) {
        return o.distance - this.distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }
}
