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
        return this.carPositions;
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getCount() {
        return this.count;
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