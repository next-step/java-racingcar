import java.util.Random;

public class GameCondition {
    public static int randomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static boolean isStart(int number) {
        return number >= 4;
    }
}
