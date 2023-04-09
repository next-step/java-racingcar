package racingcar;

public class AlwaysStopStrategy implements RandomStrategy {

    @Override
    public int getOne() {
        return (int) (Math.random() * 4);
    }
}
