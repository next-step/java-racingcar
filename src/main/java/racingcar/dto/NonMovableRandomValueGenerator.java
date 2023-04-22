package racingcar.dto;

public class NonMovableRandomValueGenerator implements RandomValueGenerator{
    @Override
    public int generate() {
        return 3;
    }
}
