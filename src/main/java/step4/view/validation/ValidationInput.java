package step4.view.validation;

public class ValidationInput {

    public static int positiveNumber(int cars) {
        if (cars < 0) {
            throw new IllegalArgumentException("음수 값을 입력할 수 없습니다.");
        }

        return cars;
    }
}
