package step1.racing;

public class IntegerEvaluator implements Evaluator<Integer> {
    @Override
    public boolean evaluate(Integer evaluateFactor, Integer threshold) {
        return evaluateFactor >= threshold;
    }
}
