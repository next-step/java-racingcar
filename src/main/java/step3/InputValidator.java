package step3;

public class InputValidator {

    public static void validate(String carNameInput, String roundInput) {
        emptyCheck(carNameInput, roundInput);

        String[] carNameArray = carNameInput.split(",");
        for (String carName : carNameArray) {
            overThanFiveCheck(carName);
        }

        unValidNumberCheck(roundInput);
    }

    private static void emptyCheck(String carNameInput, String roundInput) {
        if (carNameInput == null || carNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        if (roundInput == null || roundInput.isEmpty()) {
            throw new IllegalArgumentException("게임 진행 횟수를 입력해 주세요.");
        }
    }

    private static void overThanFiveCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자까지 입력 가능합니다.");
        }
    }

    private static void unValidNumberCheck(String roundInput) {
        int round;
        try {
            round = Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자(양수)만 입력 가능합니다.");
        }

        if (round < 0) {
            throw new IllegalArgumentException("입력값은 양수만 입력 가능합니다.");
        }
    }

}
