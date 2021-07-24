package racing.domain;

import racing.model.Car;
import racing.model.Racer;
import racing.model.Racers;
import racing.strategy.ForwardConditionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.IntStream.range;

public class RacingGame {
    private static final String NEW_LINE = System.lineSeparator();

    private RacingConfig config;

    private int stageCount;

    private RacingGame(ForwardConditionStrategy strategy, String names, int stageCount) {
        this.config = new RacingConfig(strategy, names, stageCount);
    }

    public static RacingGame init(ForwardConditionStrategy strategy, String names, int stageCount) {
        return new RacingGame(strategy, names, stageCount);
    }

    public String run() {
        StringBuilder resultDataBuilder = new StringBuilder(NEW_LINE);
        stageCount = config.stageCount;

        while (isStageGreaterThanZero()) {
            turnAround(resultDataBuilder);
            resultDataBuilder.append(NEW_LINE);
        }
        return resultDataBuilder
                .append(config.racers.winner())
                .toString().trim();
    }

    private boolean isStageGreaterThanZero() {
        return 0 < stageCount--;
    }

    private void turnAround(StringBuilder resultDataBuilder) {
        config.racers.turnAround(config.strategy, resultDataBuilder);
    }

    private class RacingConfig {
        private static final String DELIMITER = ",";

        private static final int LIMIT_RACER = 2;
        private static final int LIMIT_TRY = 1;

        private final Pattern normalPattern = Pattern.compile("(\\s,\\s)|(\\s,)|(,\\s)");

        private final ForwardConditionStrategy strategy;
        private final Racers racers;

        private int stageCount;

        private RacingConfig(ForwardConditionStrategy strategy, String string, int stageCount) {
            verify(string, stageCount);

            String[] names = string.split(DELIMITER);
            int size = names.length;

            this.strategy = strategy;
            this.stageCount = stageCount;
            this.racers = Racers.from((List<? extends Racer>) range(0, size)
                    .mapToObj(index -> Car.of(names[index], ""))
                    .collect(toCollection(ArrayList::new)));
        }

        private void verify(String names, int stageCount) {
            if (names == null || !names.contains(DELIMITER) || names.equals(DELIMITER) || isPatternMatching(names)) {
                throw new IllegalArgumentException("자동차 이름은 " + LIMIT_RACER + "개 이상이어야 하고, 공백이 있으면 안되며 쉼표(" + DELIMITER + ")로 구분되어야 합니다.");
            }

            if (stageCount < LIMIT_TRY) {
                throw new IllegalArgumentException("시도 횟수는 " + LIMIT_TRY + "회 이상이어야 합니다");
            }

            String[] strings = names.split(",");
            if (strings.length != stream(strings).distinct().count()) {
                throw new IllegalArgumentException("자동차 이름은 중복 될 수 없습니다.");
            }
        }

        private boolean isPatternMatching(String names) {
            return normalPattern.matcher(names).find();
        }
    }
}
