package racing;

public class RacingVO {
    private static RacingVO instance = new RacingVO();
    private int[] carPositions;
    private int carNumber;
    private int count;

    public RacingVO() {
    }

    public static RacingVO getInstance() {
        return instance;
    }

    public int[] getCarPositions() {
        return carPositions;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCarPositions(int[] carPositions) {
        this.carPositions = carPositions;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public void setCount(int count) {
        this.count = count;
    }
}