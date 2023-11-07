package carRacing;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static final String LINE = "-";

    public static void resultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Map<String, Integer> carStateList) {
        for (String name : carStateList.keySet()) {
            String line = LINE.repeat(carStateList.get(name));
            System.out.println(name + " : " + line);
        }
        System.out.println();
    }

    public static void printRacingWinner(List<String> nameList) {
        System.out.println(String.join(",", nameList) + " 가 최종 우승했습니다.");
    }


}
