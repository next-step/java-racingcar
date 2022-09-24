package racing;

public class ResultView {
    private static final String DISTANCE_CHARACTER = "-";

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(String str, int index) {
        System.out.println(str + " " + index);
    }

    public static void printDistance(int distance) {
        System.out.println(generateDistanceToString(distance));
    }

    private static String generateDistanceToString(int distance) {
        String stringDistance = "";
        if (distance == 0) { return stringDistance; }
        if (distance == 1) { return concatDistance(stringDistance); }

        for (int i = 0; i < distance; i++) {
            stringDistance = concatDistance(stringDistance);
        }

        return stringDistance;
    }

    private static String concatDistance(String str) {
        return str.concat(DISTANCE_CHARACTER);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
