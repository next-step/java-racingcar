package step3;

public class CarValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void nameValidator(String[] carNames) {
        for(String name:carNames) {
            nameLengthValidator(name);
        }
    }

    public static void nameLengthValidator(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자가 넘을 수 없습니다!");
        }
    }

}
