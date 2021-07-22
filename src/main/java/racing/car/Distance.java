package racing.car;

public final class Distance extends Location {
    public static final Distance DEFAULT = new Distance(1);
    public Distance(int distance) {
        super(distance);
    }
}
