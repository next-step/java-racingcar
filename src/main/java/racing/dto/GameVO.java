package racing.dto;

public class GameVO {

    private final String[] carNames;
    private final int roundNo;

    public GameVO(String[] names, int roundNo) {
        this.carNames = names;
        this.roundNo = roundNo;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getRoundNo() {
        return roundNo;
    }
}
