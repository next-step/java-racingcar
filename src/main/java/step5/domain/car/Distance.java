package step5.domain.car;

public class Distance {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance one() {
        return new Distance(1);
    }

    public static Distance of(int distance) {
        return new Distance(distance);
    }

    public void addOne() {
        this.distance++;
    }

    public void add(int distance) {
        this.distance += distance;
    }
    public String statusToString() {
        String distanceToString= "-";
        for (int i = 0; i < distance - 1; i++) {
            distanceToString = distanceToString +  "-";
        }
        return distanceToString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance1 = (Distance) o;

        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }

    public boolean fartherThan(Distance distance) {
        return this.distance > distance.distance;
    }

    public Distance deepCopy() {
        return Distance.of(this.distance);
    }
}
