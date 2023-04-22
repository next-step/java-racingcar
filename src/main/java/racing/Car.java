package racing;

public class Car {
    private final CarName carName;
    private CarPosition position;

    public Car(String name) {
        this(name,0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void move(int randomNumber) {
        if(RacingRule.moveOrStop(randomNumber)){
            position = position.move();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public CarPosition getPosition() {
        return position;
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public boolean isOnlyWinner(CarPosition maxPosition) {
        return position.isBiggerThan(maxPosition);
    }

    public boolean isSharedWinner(CarPosition maxPosition) {
        return position.isEqualThan(maxPosition);
    }
}
