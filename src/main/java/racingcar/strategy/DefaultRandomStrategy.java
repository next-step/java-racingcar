package racingcar.strategy;

public class DefaultRandomStrategy implements RandomStrategy {

    @Override
    public int getOne() {
        return (int) (Math.random() * 10);
    }
}
