package racing.dto;

public class GameVO {

    private final int carNo;
    private final int roundNo;

    public GameVO(int carNo, int roundNo) {
        this.carNo = carNo;
        this.roundNo = roundNo;
    }

    public int getCarNo() {
        return carNo;
    }

    public int getRoundNo() {
        return roundNo;
    }
}
