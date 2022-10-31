package racing;

public class RacingRecordCar {
    private final int position;
    private final String name;

    public RacingRecordCar(RacingCar racingCar) {
        this.position = racingCar.getPosition();
        this.name = racingCar.getName();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
