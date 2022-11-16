package racingcar;

public class CarValidator {
    public static void validateCount(int count) {
        if(count < 0 || count > 99) {
            throw new RuntimeException("count는 1에서 99까지의 숫자만 입력가능합니다.");
        }
    }

    public static void validateName(String name) {
        if(name == null || name.isBlank()) {
            throw new RuntimeException("name은 필수값이고 공백문자만 사용이 불가합니다.");
        }
        if(name.length() > 10) {
            throw new RuntimeException("name은 1자에서 10자까지 입력가능합니다.");
        }
    }
}
