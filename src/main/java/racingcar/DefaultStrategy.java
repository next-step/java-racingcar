package racingcar;

public class DefaultStrategy implements RandomStrategy {

    @Override
    public int getOne() {
        return (int) (Math.random() * 10);
    }
}
