package step3;

public class RacingCar {

    private int position;

    public RacingCar() {
        position = 0;
    }

    public RacingCar(int position) {
        position = 0;
    }

    public boolean goingAheadOrNot(RandomBounded randomBounded) {
        return randomBounded.moreThan4();
    }

    public RacingCar goAhead() {
        return new RacingCar(position++);
    }
}
