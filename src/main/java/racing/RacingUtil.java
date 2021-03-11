package racing;

public class RacingUtil {
    public static void start(Racing racing) {
        while (racing.hasNext()) {
            racing.runRace();
        }
    }
}
