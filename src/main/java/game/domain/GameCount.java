package game.domain;

public class GameCount {

    private final int value;

    public GameCount(int value) {
        validateGameCount(value);
        this.value = value;
    }

    private void validateGameCount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    public int getCount() {
        return value;
    }
    
}