import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    private List<List<Integer>> carResults;

    ResultView(List<List<Integer>> carResults) {
        this.carResults = carResults;
    }

    private static void showRaceProgress(int progressCount) {
        String progress = Stream.generate(()-> "-")
                .limit(progressCount <= 0 ? 1 : progressCount)
                .reduce((a, b) -> a + b).get();
        System.out.println(progress);
    }

    private static void showRaceRound(List<Integer> records) {
        records.forEach(ResultView::showRaceProgress);
        System.out.println("");
    }

    public void showRace() {
        System.out.println("실행 결과");
        carResults.forEach(ResultView::showRaceRound);
    }
}
