package step1.racing;

import java.util.List;
import java.util.stream.IntStream;

import step1.racing.data.RacingCar;

public class PositionSetter<T extends Number> {
    private final Evaluator<T> evaluator;
    private final T threshold;

    public PositionSetter(Evaluator<T> evaluator, String winningThreshold) {
        this.evaluator = evaluator;
        this.threshold = evaluator.parseValue(winningThreshold);
    }

    public void movePosition(List<RacingCar> target, List<T> evaluationFactors) {
        IntStream.range(0, target.size())
                 .forEach(index -> updatePositionIfWon(target, evaluationFactors, index));
    }

    private void updatePositionIfWon(List<RacingCar> target, List<T> evaluationFactors, int index) {
        if (evaluator.evaluate(evaluationFactors.get(index), threshold)) {
            target.get(index).moveForward();
        }
    }
}
