package step1.racing;

public class EvaluatorFactory {
    public static Evaluator getEvaluator(Class type) {
        if (type == Integer.class) {
            return new IntegerEvaluator();
        }

        throw new IllegalArgumentException("Wrong value format");
    }
}
