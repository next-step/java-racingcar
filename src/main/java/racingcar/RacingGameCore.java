package racingcar;

import java.util.ArrayList;

class RacingGameCore {
    private final RacingCars racingCars;
    private int stageCount;

    private static final String INITIAL_POSITION_VALUE = "";

    private RacingGameCore(final int carCount, final int stageCount) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            stringArrayList.add(INITIAL_POSITION_VALUE);
        }
        this.racingCars = RacingCars.from(stringArrayList);
        this.stageCount = stageCount;
    }

    static RacingGameCore of(final int carCount, final int stageCount) {
        return new RacingGameCore(carCount, stageCount);
    }

    private StringBuilder gameResult;

    String run() {
        gameResult = new StringBuilder();

        while (0 != stageCount--) {
            moveForwardWhenConditions();
            gameResult.append("\n");
        }
        return gameResult.toString().trim();
    }

    private void moveForwardWhenConditions() {
        for (int index = 0; index < racingCars.size(); index++) {
            racingCars.goForward(index, RandomNumberGenerator.generate());
            gameResult.append(racingCars.get(index)).append("\n");
        }
    }
}
