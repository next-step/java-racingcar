package racingcar.domain;

public class RandomMove implements MoveStrategy{

    @Override
    public int movable() {
        return RandomGenerate.makeRandom();
    }
}
