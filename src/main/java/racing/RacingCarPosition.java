package racing;

public class RacingCarPosition {

    private final String carName;
    private Integer carPosition;

    public RacingCarPosition(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public void move() {
        this.carPosition++;
    }

    public String getCarName() {
        return this.carName;
    }

    public Integer getCarPosition() {
        return this.carPosition;
    }

}
