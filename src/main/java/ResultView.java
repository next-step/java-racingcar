import java.util.List;

public class ResultView {
    public static void showRaceRound(List<String> progress) {
        progress.forEach(System.out::println);
        System.out.println();
    }

    public static void showWinners(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
