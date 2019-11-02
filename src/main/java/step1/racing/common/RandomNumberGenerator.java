package step1.racing.common;

public interface RandomNumberGenerator<T extends Number> {
    T gacha(int bound);
}
