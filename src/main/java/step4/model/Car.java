package step4.model;

import java.util.Objects;

public class Car {

    private final Name name;
    private Distance distance;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
            this.distance = this.distance.increase();
        }
    }
    public Distance max(Distance other) {
        return this.distance.farthestDistance(other);
    }

    public boolean isWinner(Distance maxPosition) {
        return this.distance.equals(maxPosition);
    }

    public int distance() {
        return distance.distance();
    }

    public String name() {
        return name.name();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Car car = (Car) other;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(name());
        sb.append(CarRacingConstant.COLON);
        for(int i = 0; i < distance(); i++){
            sb.append(CarRacingConstant.DASH);
        }
        return sb.toString();
    }
}
