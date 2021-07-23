package racing;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.IntStream.range;

class RacingGame {
    private static final String END_MESSAGE_FORMAT = "실행 결과";
    private static final String NEW_LINE = System.lineSeparator();

    private static final int LIMIT_RACER = 2;
    private static final int LIMIT_TRY = 1;

    private final ForwardConditionStrategy strategy;
    private final Racers racers;

    private int stageCount;

    private RacingGame(ForwardConditionStrategy strategy, int racerCount, int stageCount) {
        if (racerCount < LIMIT_RACER) {
            throw new IllegalArgumentException("자동차는 " + LIMIT_RACER + "대 이상이어야 합니다");
        }

        if (stageCount < LIMIT_TRY) {
            throw new IllegalArgumentException("시도 횟수는 " + LIMIT_TRY + "회 이상이어야 합니다");
        }

        this.strategy = strategy;
        this.stageCount = stageCount;
        this.racers = Racers.from((List<? extends Racer>) range(0, racerCount)
                .mapToObj(it -> Car.emptyCar())
                .collect(toCollection(ArrayList::new)));
    }

    public static RacingGame of(ForwardConditionStrategy strategy, int racerCount, int stageCount) {
        return new RacingGame(strategy, racerCount, stageCount);
    }

    private StringBuilder resultDataBuilder;

    public String run() {
        resultDataBuilder = new StringBuilder(END_MESSAGE_FORMAT).append(NEW_LINE);
        while (isStageGreaterThanZero()) {
            turnAround();
            resultDataBuilder.append(NEW_LINE);
        }
        return resultDataBuilder.toString().trim();
    }

    private boolean isStageGreaterThanZero() {
        return 0 < stageCount--;
    }

    private void turnAround() {
        racers.turnAround(strategy, resultDataBuilder);
    }
}
