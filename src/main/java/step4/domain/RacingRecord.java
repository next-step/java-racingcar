package step4.domain;

import java.util.Objects;

public class RacingRecord {
    private String carName;
    private int position;

    public RacingRecord(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingRecord that = (RacingRecord) o;
        return position == that.position && Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
