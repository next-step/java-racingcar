package step4;

public class Separator {
    private static final String SEPARATOR = ",";
    public static String[] separateCarNames(String carNames) {
        return carNames.split(SEPARATOR);
    }
}
