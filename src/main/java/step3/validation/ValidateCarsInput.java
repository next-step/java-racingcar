package step3.validation;

public class ValidateCarsInput {

    public static int positiveNumber(int cars) {
        if (cars < 0) {
            throw new IllegalArgumentException("자동차 대수는 음수 값을 입력할 수 없습니다.");
        }

        return cars;
    }
}
