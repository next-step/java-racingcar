package carracing.domain;

import java.util.Objects;

public class Distance {
    int value;

    public Distance(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Distance는 0 이상 이어야 합니다.");
        }
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