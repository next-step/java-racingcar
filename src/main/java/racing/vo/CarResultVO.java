package racing.vo;

public class CarResultVO implements Comparable<CarResultVO> {

    private final String name;
    private final int distance;

    public CarResultVO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(CarResultVO o) {
        return o.distance - this.distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSameDistance(int bestDistance) {
        return bestDistance == distance;
    }
}
