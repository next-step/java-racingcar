package step2;

/**
 * @author : 0giri
 * @since : 2023/04/13
 */
public class Positive {

    private final int positive;

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
        this.positive = number;
    }

    public int value() {
        return positive;
    }
}
