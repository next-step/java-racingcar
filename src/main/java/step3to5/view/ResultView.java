package step3to5.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printRaceResult(String name, int score, String symbol) {
        System.out.printf("%5s : ", name);
        for (int i = 0; i < score; i++) {
            System.out.printf("%s", symbol);
        }
        System.out.println();
    }

    public static void printChampions(List<String> championsList) {
        String champion = convertToStringFromList(championsList);
        System.out.println(champion + "가 최종 우승했습니다.");
    }

    public static String convertToStringFromList(List<String> list) {
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return result;
    }
}
