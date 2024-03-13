package racing.dto;

import racing.Constant;

public class GameVO {

    private final int carNo;
    private final int roundNo;

    private GameVO(int carNo, int roundNo) {
        this.carNo = carNo;
        this.roundNo = roundNo;
    }

    public static GameVO validateInput(int carNo, int roundNo) {
        if (carNo <= 0) {
            throw new IllegalArgumentException(Constant.CAR_NUMBER_VALIDATION_ERROR);
        }

        if (roundNo <= 0) {
            throw new IllegalArgumentException(Constant.ROUND_NUMBER_VALIDATION_ERROR);
        }
        return new GameVO(carNo, roundNo);
    }

    public int getCarNo() {
        return carNo;
    }

    public int getRoundNo() {
        return roundNo;
    }
}
