package racingcar;

public class Parser {
    public static String[] parse(String input) {
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            validateName(carName);
        }

        return carNames;
    }

    private static void validateName(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new RuntimeException("이름은 다섯자 이하만 가능합니다.");
        }
    }
}
