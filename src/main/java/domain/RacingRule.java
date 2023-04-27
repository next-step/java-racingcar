package domain;

public class RacingRule {

    private static int MOVABLE_NUMBER = 4;

    public static boolean moveOrStop(int randomNumber) {
        return randomNumber >= MOVABLE_NUMBER;
    }
}