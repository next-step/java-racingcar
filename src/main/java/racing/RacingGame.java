package racing;

import java.util.ArrayList;

class RacingGame {
    private static final String BLANK = "";

    private final RacingCars racingCars;

    private int stageCount;

    private RacingGame(int carCount, int stageCount) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            stringArrayList.add(BLANK);
        }
        this.racingCars = RacingCars.from(stringArrayList);
        this.stageCount = stageCount;
    }

    public static RacingGame from(int[] condition) {
        return new RacingGame(condition[0], condition[1]);
    }

    private StringBuilder sb;

    public String run() {
        sb = new StringBuilder();
        while(isStageGreaterThanZero()) {
            turnAround();
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private boolean isStageGreaterThanZero() {
        return 0 <= stageCount--;
    }

    private void turnAround() {
        for(int index = 0; index < racingCars.size(); index++) {
            racingCars.goForward(index, RandomNumberGenerator.generate());
            sb.append(racingCars.get(index)).append("\n");
        }
    }
}
