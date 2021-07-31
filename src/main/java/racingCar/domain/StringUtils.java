package racingCar.domain;

public class StringUtils {
    private static final int THRESHOLD = 5;

    private StringUtils() {
    }

    public static String[] namesSpliter(String names){
        return names.split(",");
    }

    public static boolean checkStringLength(String name){
        return name.length() <= THRESHOLD;
    }

}
