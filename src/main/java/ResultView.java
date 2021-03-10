import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    private static void showRaceProgress(int progressCount) {
        String progress = Stream.generate(()-> "-")
                .limit(progressCount)
                .reduce("-", (a, b) -> a + b);
        System.out.println(progress);
    }

    public static void showRaceRound(List<Integer> records) {
        records.forEach(ResultView::showRaceProgress);
        System.out.println("");
    }
}
