package step3;


public class GameRule {
    public static int RANDOM_LIMIT = 10;
    public static int STRAIGHT_CRITERIA = 4;

    public static boolean isGoStraight(int number) {
        return number >= STRAIGHT_CRITERIA;
    }
}
