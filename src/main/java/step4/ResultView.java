package step4;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printResult(List<String> winner) {
        System.out.println("실행 결과");
        System.out.println(winner + "가 최종우승했습니다.");
    }

    public static void printProcess(Map<String, Integer> cars) {
        StringBuilder sb = new StringBuilder();
        makeRacingMessage(cars, sb);
        System.out.println(sb);
    }

    private static void makeRacingMessage(Map<String, Integer> cars, StringBuilder sb) {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append("-".repeat(entry.getValue())).append("\n");
        }
    }
}
