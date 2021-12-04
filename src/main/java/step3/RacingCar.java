package step3;


public class RacingCar {
    private Distance distance;
    private Name name;

    public RacingCar(Distance distance) {
        this(distance, new Name(""));
    }

    public RacingCar(Distance distance, Name name) {
        this.distance = distance;
        this.name = name;
    }


    public boolean isMove(RamdomCondition ramdomCondition) {
        return ramdomCondition.meet();
    }

    public void move(RamdomCondition ramdomCondition) {
        if (isMove(ramdomCondition)) {
            this.distance = this.distance.move();
        }
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public String getName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof RacingCar)) {
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
        hashCode = 31 * hashCode + Integer.hashCode(distance.hashCode());

        return hashCode;
    }
}
