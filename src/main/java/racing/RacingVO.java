package racing;

public class RacingVO {


    private int[] carPositions;
    private int carNumber;
    private int count;


    public RacingVO(int carNumber, int count, int[] carPositions) {
        this.carNumber = carNumber;
        this.count = count;
        this.carPositions = carPositions;

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


}