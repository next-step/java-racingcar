package racingcar;

public class RacingRecord {

    private Car car;
    private int position;

    public RacingRecord(Car car, int position) {
        this.car = car;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}