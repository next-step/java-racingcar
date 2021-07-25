package racing.domain;

import racing.model.Car;
import racing.model.Racer;
import racing.model.Racers;
import racing.strategy.ForwardConditionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingGame {
    private final Racers<? extends Racer> racers;

    private RacingConfig config;

    private int stageCount;

    private RacingGame(ForwardConditionStrategy strategy, String names, int stageCount) {
        this.config = new RacingConfig(strategy, names, stageCount);
        this.racers = stream(names.split(RacingConfig.DELIMITER))
                .map(name -> Car.of(name))
                .collect(collectingAndThen(toList(), Racers::from));
    }

    public static RacingGame init(ForwardConditionStrategy strategy, String names, int stageCount) {
        return new RacingGame(strategy, names, stageCount);
    }

    public List<Racers> run() {
        stageCount = config.immutableStageCount;
        List<Racers> resultList = new ArrayList<>();
        while (isStageGreaterThanZero()) {
            turnAround(resultList);
        }
        return resultList;
    }

    private boolean isStageGreaterThanZero() {
        return 0 < stageCount--;
    }

    private void turnAround(List<Racers> resultList) {
        racers.turnAround(config.strategy, resultList);
    }

    private static class RacingConfig {
        private static final String DELIMITER = ",";

        private static final int LIMIT_RACER = 2;
        private static final int LIMIT_TRY = 1;

        private final Pattern normalPattern = Pattern.compile("(\\s,\\s)|(\\s,)|(,\\s)");
        private final ForwardConditionStrategy strategy;

        private final int immutableStageCount;

        private RacingConfig(ForwardConditionStrategy strategy, String names, int stageCount) {
            verify(names, stageCount);

            this.strategy = strategy;
            this.immutableStageCount = stageCount;
        }

        private void verify(String names, int stageCount) {
            if (names == null || !names.contains(DELIMITER) || names.equals(DELIMITER) || isPatternMatching(names)) {
                throw new IllegalArgumentException("자동차 이름은 " + LIMIT_RACER + "개 이상이어야 하고, 공백이 있으면 안되며 쉼표(" + DELIMITER + ")로 구분되어야 합니다.");
            }

            if (stageCount < LIMIT_TRY) {
                throw new IllegalArgumentException("시도 횟수는 " + LIMIT_TRY + "회 이상이어야 합니다");
            }

            String[] strings = names.split(DELIMITER);
            if (strings.length != stream(strings).distinct().count()) {
                throw new IllegalArgumentException("자동차 이름은 중복 될 수 없습니다.");
            }
        }

        private boolean isPatternMatching(String names) {
            return normalPattern.matcher(names).find();
        }
    }
}
