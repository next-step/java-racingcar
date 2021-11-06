package racingStep3;

public class RacingCar {

    private Position position;

    public RacingCar() {
        this(new Position());
    }

    public RacingCar(Position position) {
        this.position = position;
    }

    public void moveOrNot(int randomNumber) {
        if(randomNumber > 3) {
            this.position = new Position(this.position.value() + 1);
        }
    }

    public int getPosition() {
        return this.position.value();
    }
}
