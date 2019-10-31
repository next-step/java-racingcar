package step1.racing;

public class IntegerEvaluator implements Evaluator<Integer> {
    @Override
    public boolean evaluate(Integer evaluateFactor, Integer threshold) {
        return evaluateFactor >= threshold;
    }

    @Override
    public Integer parseValue(String value) {
        return Integer.valueOf(value);
    }
}
