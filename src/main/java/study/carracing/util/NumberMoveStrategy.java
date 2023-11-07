package study.carracing.util;

public class NumberMoveStrategy implements MoveStrategy{

    private NumberGenerator numberGenerator;
    private int number;

    public NumberMoveStrategy(NumberGenerator numberGenerator, int number) {
        this.numberGenerator = numberGenerator;
        this.number = number;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generatorNumber() >= number;
    }
}
