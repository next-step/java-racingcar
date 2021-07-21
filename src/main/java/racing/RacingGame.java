package racing;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RacingGame {
    private static final String BLANK = "";

    private final RacingCars racingCars;
    private final ForwardConditionStrategy strategy;

    private int stageCount;

    private RacingGame(ForwardConditionStrategy strategy, int carCount, int stageCount) {
        this.stageCount = stageCount;
        this.strategy = strategy;
        this.racingCars = RacingCars.from(IntStream.range(0, carCount)
                                                   .mapToObj(i -> BLANK)
                                                   .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static RacingGame from(ForwardConditionStrategy strategy, int[] condition) {
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
