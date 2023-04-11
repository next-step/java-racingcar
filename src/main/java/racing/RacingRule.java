package racing;

public class RacingRule {

    private static int BASE_NUMBER = 4;

    public static int goOrStop(int number) {
        if(number >= BASE_NUMBER){
            return go();
        }
        return stop();
    }

    public static int go() {
        return 1;
    }

    public static int stop() {
        return 0;
    }
}
