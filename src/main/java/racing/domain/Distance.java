package racing.domain;

public class Distance {
    public static final Distance zero = new Distance(0);

    public static final Distance one = new Distance(1);

    private final int distance;

    private Distance(int distance){
        this.distance = distance;
    }

    public Distance plus(Distance distance) {
        return new Distance(this.distance + distance.distance);
    }

    public int getDistance(){
        return distance;
    }
}
