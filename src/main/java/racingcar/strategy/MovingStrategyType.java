package racingcar.strategy;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum MovingStrategyType {
    RANDOM(RandomMovingStrategy::new);

    private final Supplier<MovingStrategy> strategySupplier;

    MovingStrategyType(Supplier<MovingStrategy> strategySupplier) {
        this.strategySupplier = strategySupplier;
    }

    public static MovingStrategy getStrategy(MovingStrategyType givenType) {
        return Stream.of(values())
                .filter(type -> type.equals(givenType))
                .findFirst()
                .map(type -> type.strategySupplier.get())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 strategy type 입니다"));
    }

}
