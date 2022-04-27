package study.step4.try2.domain;

public class CarNames {
    private final int LIMITED_STRING_LENGTH = 5;

    private final String[] carNames;

    // private 이지만 테스트를 위해 public 으로 변경
    public CarNames(String userInputCarNames) {
        if (!valid(userInputCarNames)) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        this.carNames = userInputCarNames.split(",");
    }

    // of: 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
    public static CarNames of(String userInputCarNames) {
        return new CarNames(userInputCarNames);
    }

    // private 이지만 테스트를 위해 public 으로 변경
    public boolean valid(String userInputCarNames) {
        if (userInputCarNames.isEmpty()) {
            return false;
        }
        String[] userInputCarNamesArray = userInputCarNames.split(",");
        for (String value : userInputCarNamesArray) {
            if (value.length() > LIMITED_STRING_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
