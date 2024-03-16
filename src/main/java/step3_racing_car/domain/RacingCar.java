package step3_racing_car.domain;

import java.util.Objects;

public class RacingCar {
    private Position position;
    private Name name;

    public RacingCar(final String name){
        this(name, 0);
    }
    public RacingCar(final String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public int max(int other){
        return this.position.max(other);
    }
    public boolean isMatch(int maxPosition){
        return this.position.isMatch(maxPosition);
    }

    public void movePositions(int distance) {
        this.position.move(distance);
    }

    public Position getPosition(){
        return position;
    }
    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString() + " : " + position.toString();
    }
}
