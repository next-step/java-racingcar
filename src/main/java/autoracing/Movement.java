package autoracing;

import java.util.Objects;

public class Movement {
    public static Movement STATIONARY = new Movement(0);
    public static Movement ONE_FORWARD = new Movement(1);
    public static Movement from(int distance) {
        if (distance == 0) {
            return STATIONARY;
        }
        if (distance == 1) {
            return ONE_FORWARD;
        }
        return new Movement(distance);
    }

    private int distance;

    private Movement(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }


    /**
     * reference by https://medium.com/better-programming/equality-and-comparison-in-java-pitfalls-and-best-practices-96b713e7009
     */
    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    /**
     * reference by https://medium.com/better-programming/equality-and-comparison-in-java-pitfalls-and-best-practices-96b713e7009
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Movement other = (Movement) obj;
        // Let the helper do the rest
        return Objects.equals(this.distance, other.distance);
    }
}
