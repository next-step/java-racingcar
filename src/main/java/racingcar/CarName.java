package racingcar;

public class CarName {
    private final static int TEXT_LENGTH_LIMIT = 5;
    private final String text;

    public CarName(String text) {
        if (text.length() > TEXT_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.text = text;
    }

    public String getText() {
        return text;
    }
}
