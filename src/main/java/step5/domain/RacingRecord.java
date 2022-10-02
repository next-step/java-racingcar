package step5.domain;

import java.util.Objects;

public class RacingRecord {
    private Name carName;
    private Position position;

    public RacingRecord(Name carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingRecord that = (RacingRecord) o;
        return Objects.equals(carName, that.carName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    public Position greaterOrEqualPosition(Position position) {
        if(this.position.greaterOrEqual(position)){
            return this.position;
        }
        return position;
    }

    public boolean hasSamePosition(Position position) {
        return this.position.equals(position);
    }
}
