package domain;

import util.RacingCarUtil;

public class RacingGame {

    private final static int MAX = 10;
    private final static int MOVE_CONDITION = 4;

    private int carNo;
    private int[] carPositions;

    public RacingGame(int carNo) {
        this.carNo = carNo;
        this.carPositions = new int[carNo];
    }

    @Override
    public boolean equals(Object object) {
        return this.carNo == ((RacingGame) object).carNo;
    }

    public int[] move() {
        for (int i = 0; i < carPositions.length; i++) {
            if (isMetConditionToMove()) {
                carPositions[i]++;
            }
        }
        return carPositions;
    }

    public boolean isMetConditionToMove() {
        return RacingCarUtil.getRandomNumber(MAX) >= MOVE_CONDITION;
    }


}
