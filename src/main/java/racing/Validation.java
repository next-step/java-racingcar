package racing;

public class Validation {

    public void validStringEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 한다.");
        }
    }

    public void validStringLength(String value, int checkLength) {
        if (value.length() > checkLength) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할수 없습니다.");
        }
    }

    public void validNumberCheck(String value) {
        String regExp = "^\\d+$";
        if (!value.matches(regExp)) {
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }

}
