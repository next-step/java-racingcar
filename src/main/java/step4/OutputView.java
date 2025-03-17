package step4;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printRaceProgress(String raceProgress) {
        System.out.println("실행 결과");
        System.out.println(raceProgress);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
