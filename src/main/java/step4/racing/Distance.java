package step4.racing;

import step4.racing.inout.OutPutView;

public class Distance {
    private int distance;

    private Distance(int howFar) {
        this.distance = howFar;
    }

    public static Distance of(int howFar) {
        return new Distance(howFar);
    }

    public void plus(int howFar) {
        distance += howFar;
    }

    public boolean fartherThan(Distance distance) {
        return distance.fatherDistanceThan(this.distance);
    }

    private boolean fatherDistanceThan(int distance) {
        return distance > this.distance;
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

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }

    public void print(OutPutView outPutView) {
        outPutView.printDistance(distance);
    }
}
