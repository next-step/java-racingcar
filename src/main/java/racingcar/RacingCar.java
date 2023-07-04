package racingcar;

public class RacingCar {

    public static boolean isValidCarNames(String rawCarNames) {
        String[] carNames = rawCarNames.split(",");
        return !isEmptyCarNames(carNames) && isValidCarNamesLength(carNames);
    }

    private static boolean isValidCarNamesLength(String[] carNames) {
        boolean result = true;
        for (String carName : carNames) {
            result &= isValidCarNameLength(carName.trim());
        }
        return result;
    }

    private static boolean isEmptyCarNames(String[] carNames) {
        if (carNames.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean isValidCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidCount(String count) {
        return count.trim().matches("^[0-9]+$");
    }
}
