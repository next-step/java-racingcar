package step3.view;

import step3.utils.ConvertToStringFromList;

import java.util.List;

public class ResultView {
    public static void printRaceResult(String name, int score, String symbol) {
        System.out.printf("%5s : ", name);
        for (int i = 0; i < score; i++) {
            System.out.printf("%s", symbol);
        }
        System.out.println();
    }

    public static void printChampions(List<String> championsList) {
        String champion = ConvertToStringFromList.convertToStringFromList(championsList);
        System.out.println(champion + "가 최종 우승했습니다.");
    }
}
