package racing;

public class RacingUtil {
    public static void start(Racing racing) {
        while (racing.hasNext()) {
            racing.runRace();
        }
    }

    public static void showResult(Racing racing) {
        final ResultView resultView = new ResultView();

        for (Round round : racing.getRounds()) {
            resultView.show(round.getCars());
            System.out.println();
        }
    }
}
