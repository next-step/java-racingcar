package edu.nextstep.camp.carracing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    private CarValidator() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void checkForDuplicateCarNames(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
