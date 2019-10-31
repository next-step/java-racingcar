package step1.racing.factories;

import step1.racing.Evaluator;
import step1.racing.IntegerEvaluator;

public class EvaluatorFactory {
    public static Evaluator getEvaluator(Class type) {
        if (type == Integer.class) {
            return new IntegerEvaluator();
        }

        throw new IllegalArgumentException("Wrong value format");
    }
}
