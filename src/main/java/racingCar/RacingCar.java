package racingCar;

public class RacingCar {
    private int position;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCar(int position, RandomNumberGenerator randomNumberGenerator) {
        this.position = position;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "RacingCar{" + "position=" + position + '}';
    }

    void progress() {
        if (randomNumberGenerator.makeRandomNumber() >= 4){
            incPosition();
        }
    }

    protected void incPosition() {
        ++this.position;
    }
}
