package race.util;

public class Distance {

    private static final String MARKING = "-";

    private Distance(){}

    public static String get(int distance) {
        return MARKING.repeat(distance);
    }
}
