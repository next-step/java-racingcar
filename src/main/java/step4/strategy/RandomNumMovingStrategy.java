package step4.strategy;


import step4.util.RandomGenerator;

public class RandomNumMovingStrategy implements MovingStrategy{
    private static final int CONDITION = 4;

    @Override
    public boolean canForward() {
        return RandomGenerator.makeRandomInt() >= CONDITION;
    }
}
