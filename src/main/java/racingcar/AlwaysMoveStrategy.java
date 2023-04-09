package racingcar;

public class AlwaysMoveStrategy implements RandomStrategy {

    @Override
    public int getOne() {
        return (int) (Math.random() * 6 + 4);
    }
}
