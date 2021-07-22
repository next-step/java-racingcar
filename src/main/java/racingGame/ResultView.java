package racingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(List<Integer> list) {
        List<String> collect = list.stream()
                .map(ResultView::parseIntegerToBar)
                .collect(Collectors.toList());
        for (String str : collect) {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void printGameStart() {
        System.out.println("실행결과");
    }

    public static String parseIntegerToBar(int value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
