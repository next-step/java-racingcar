package racingcar;

public class Parser {
    public static String[] parse(String input) {
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new RuntimeException("이름은 다섯자 이하만 가능합니다.");
            }
        }

        return carNames;
    }
}
