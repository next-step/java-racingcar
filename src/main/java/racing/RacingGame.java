package racing;

import java.util.ArrayList;

class RacingGame {
    private static final String BLANK = "";

    private final RacingCars racingCars;
    private final ForwardStrategy strategy;

    private int stageCount;

    private RacingGame(ForwardStrategy strategy, int carCount, int stageCount) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            stringArrayList.add(BLANK);
        }
        this.racingCars = RacingCars.from(stringArrayList);
        this.stageCount = stageCount;
        this.strategy = strategy;
    }

    public static RacingGame from(ForwardStrategy strategy, int[] condition) {
        return new RacingGame(strategy, condition[0], condition[1]);
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
            racingCars.goForward(index, strategy);
            sb.append(racingCars.get(index)).append("\n");
        }
    }
}
