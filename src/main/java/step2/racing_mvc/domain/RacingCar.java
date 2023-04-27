package step2.racing_mvc.domain;

import java.util.Objects;

public class RacingCar {
    private final RacingCarName carName;
    private RacingCarPosition position;

    public RacingCar(String name) {
        this(name,0);
    }

    public RacingCar(String name, int position) {
        this.carName = new RacingCarName(name);
        this.position = new RacingCarPosition(position);
    }

    public void move(int randomNumber) {
        if(RacingGameRule.moveOrStop(randomNumber)){
            position = position.move();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public RacingCarPosition getPosition() {
        return position;
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public boolean isOnlyWinner(RacingCarPosition maxPosition) {
        return position.isBiggerThan(maxPosition);
    }

    public boolean isSharedWinner(RacingCarPosition maxPosition) {
        return position.isEqualThan(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar car = (RacingCar) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}