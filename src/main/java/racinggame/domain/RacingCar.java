package racinggame.domain;


public class RacingCar {
    private final Distance distance;
    private final Name name;

    public RacingCar(final Distance distance) {
        this(distance, new Name(""));
    }

    public RacingCar(final Distance distance, Name name) {
        this.distance = distance;
        this.name = name;
    }

    public boolean isMove(RamdomCondition ramdomCondition) {
        return ramdomCondition.meet();
    }

    public RacingCar move(RamdomCondition ramdomCondition) {
        if (isMove(ramdomCondition)) {
            return new RacingCar(this.distance.move(), this.name);
        }
        return this;
    }

    public boolean isDistanceEquals(Distance compareDistance) {
        return this.distance.equals(compareDistance);
    }

    public boolean isEqualDistance(Distance distance) {
        return this.distance.equals(distance);
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public String getName() {
        return this.name.getName();
    }

    public Distance findTopDistance(Distance distance) {
        if(this.distance.isFarAWay(distance)) {
            return this.distance;
        }
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RacingCar)) {
            return false;
        }

        RacingCar racingCar = (RacingCar) obj;

        return this.name.equals(racingCar.name)
                && this.distance.equals(racingCar.distance);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + distance.hashCode();

        return hashCode;
    }
}
