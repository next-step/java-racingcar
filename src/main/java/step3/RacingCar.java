package step3;

public class RacingCar {

    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public RacingCar(int position) {
        this.position = position;
    }

    public boolean goingAheadOrNot(RandomBounded randomBounded) {
        return randomBounded.moreThan4();
    }

    public RacingCar goAhead() {
        return new RacingCar(++position);
    }

    public int position() {
        return this.position;
    }
}
