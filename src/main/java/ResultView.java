import java.util.List;
import java.util.stream.Stream;

public class ResultView {
    private static void showRaceProgress(int progressCount) {
        String progress = Stream.generate(()-> "-")
                .limit(progressCount <= 0 ? 1 : progressCount)
                .reduce((a, b) -> a + b).get();
        System.out.println(progress);
    }

    public static void showRaceNumberOfTimes(List<Integer> numberOfTimes) {
        for (int number: numberOfTimes) {
            showRaceProgress(number);
        }
        System.out.println("");
    }
}
