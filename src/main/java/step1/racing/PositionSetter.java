package step1.racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PositionSetter<T extends Number> {
    private final Evaluator<T> evaluator;
    private final T threshold;

    public PositionSetter(Evaluator<T> evaluator, String winningThreshold) {
        this.evaluator = evaluator;
        this.threshold = evaluator.parseValue(winningThreshold);
    }

    public List<Integer> movePosition(List<Integer> target, List<T> evaluationFactors) {
        return IntStream.range(0, target.size())
                 .map(index -> updatePositionIfWon(target, evaluationFactors, index))
                 .boxed()
                 .collect(Collectors.toList());
    }

    private int updatePositionIfWon(List<Integer> target, List<T> evaluationFactors, int index) {
        if (evaluator.evaluate(evaluationFactors.get(index), threshold)) {
            return target.get(index) + 1;
        }
        return target.get(index);
    }
}
