package carrace.ui.input.scanner;

public class NameValidator {
    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(String carName) {
        if(carName.length() > 5)
            throw new IllegalArgumentException();
    }
}
