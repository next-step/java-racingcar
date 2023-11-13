package step4.view.validation;

import java.util.Arrays;
import java.util.List;

public class ValidationInput {

    public static int positiveNumber(int cars) {
        if (cars < 0) {
            throw new IllegalArgumentException("음수 값을 입력할 수 없습니다.");
        }

        return cars;
    }

    public static List<String> verifyInputLength(String text) {
        List<String> carNames =  Arrays.asList(text.split(","));
        carNames.stream().filter(carName -> carName.length() > 5).findFirst()
            .ifPresent(e -> {
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
            });

        return carNames;
    }
}
