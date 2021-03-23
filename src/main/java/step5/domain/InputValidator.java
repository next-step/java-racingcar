package step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private InputValidator() {}

    public static void checkCarName(List<String> carName) {
        int errorInputSize = carName.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList())
                .size();

        // stream 으로 한번에 표현하는게 있을 거 같긴 합니다 ㅠ
        if (errorInputSize > 0) {
            throw new IllegalArgumentException("입력이 5자 이상입니다.");
        }
    }

    public static void checkTryCountIsMinus(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수가 잘못되었습니다.");
        }
    }
}
