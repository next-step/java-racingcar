package racingcar.domain;

public class NonMovableRandomValueGenerator implements RandomValueGenerator{
    @Override
    public int generate() {
        return 3;
    }
}
