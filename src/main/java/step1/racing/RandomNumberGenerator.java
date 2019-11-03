package step1.racing;

public interface RandomNumberGenerator<T extends Number> {
    T gacha(int bound);
}
