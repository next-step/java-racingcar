package step2;

public class PositiveParser {
    private final int value;

    public PositiveParser(String value) {
        int parsed = Integer.parseInt(value);

        if (parsed < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        this.value = parsed;
    }

    public int parse() {
        return value;
    }
}
