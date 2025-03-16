package edu.nextstep.camp.carracing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    private CarValidator() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }
    
    public static void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 null이거나 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static void checkForDuplicateCarNames(String[] carNames) {
        Set<String> carNamesSet = new HashSet<>(List.of(carNames));
        if (carNamesSet.size() != carNames.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
