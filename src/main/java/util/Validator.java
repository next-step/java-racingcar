package util;

public class Validator {
    public static boolean isValidNumberOfCars(int num) {
        return num > 0;
    }

    public static boolean isValidNumberOfGames(int num) {
        return num > 0;
    }

    public static boolean isValidCarNameLength(String name) {
        return name.length() <= 5;
    }
}
