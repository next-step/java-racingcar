package racingcar.race;

class RacingTestRule implements RacingRule {

    private final int[] winnerTargetIndex;
    private int carNameIndex = 0;

    public RacingTestRule(int[] winnerTargetIndex) {
        this.winnerTargetIndex = winnerTargetIndex;
    }

    @Override
    public int getMoveForward() {
        carNameIndex++;
        int moveCount = 0;
        for (int i = 0 ; (i < winnerTargetIndex.length) && moveCount == 0 ; i++) {
            moveCount = getMoveCount(winnerTargetIndex[i] + 1);
        }
        return moveCount;
    }

    private int getMoveCount(int targetIndex) {
        if(carNameIndex % targetIndex == 0) {
            return 5;
        }
        return 0;
    }
}