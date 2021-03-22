package step03;

public class RacingCarDTO {
    private int movingRange;
    private String carName;

    RacingCarDTO(String carName, int movingRange) {
        this.carName = carName;
        this.movingRange = movingRange;
    }

    public int getMovingRange() {
        return movingRange;
    }

    public void setMovingRange(int movingRange) {
        this.movingRange = movingRange;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
