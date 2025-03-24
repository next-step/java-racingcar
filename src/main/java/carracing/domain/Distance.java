package carracing.domain;

import java.util.Objects;

public class Distance {
    int value;

    public Distance(int value) {
        this.value = value;
    }

    public Distance add(int i) {
        ++value;
        return this;
    }

    public String makeString() {
        String distanceString = "";
        for (int i = 0; i < value; ++i) {
            distanceString += "-";
        }
        return distanceString;
    }

    public boolean hasSameValue(int maxDistance) {
        return value == maxDistance;
    }

    public int returnMaxValue(int maxDistance) {
        return Math.max(maxDistance, value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}