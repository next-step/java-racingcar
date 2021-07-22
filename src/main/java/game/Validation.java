package game;

public class Validation {

    private Utils utils;

    public Validation(Utils utils) {
        this.utils = utils;
    }

    public void validStringEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 한다.");
        }
    }

    public void validStringLength(String value, int checkLength) {
        if (utils.stringLength(value) > checkLength) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할수 없습니다.");
        }
    }


}
