package step_3.util;

import step_3.model.RoundResult;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class BehaviorCombiner {

    private BehaviorCombiner() {
    }

    public static IntFunction<String> combined(List<RoundResult> roundResults) {
        return roundNumber -> {
            Set<String> racingCarIds = roundResults.get(0).getRacingCarIds();
            AtomicReference<String> forwardSymbols = new AtomicReference<>("");

            racingCarIds.forEach(id -> {
                IntStream.range(0, roundNumber).forEach(thisRound -> {
                    RoundResult thisRoundResult = roundResults.get(thisRound);
                    forwardSymbols.getAndAccumulate(thisRoundResult.getBehavior(id).symbol, (before, after) -> before += after);
                });
                forwardSymbols.getAndAccumulate("\n", (before, after) -> before += after);
            });
            forwardSymbols.getAndAccumulate("\n", (before, after) -> before += after);

            return forwardSymbols.get();
        };
    }
}
