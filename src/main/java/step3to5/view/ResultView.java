package step3to5.view;

import step3to5.domain.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printRaceResult(ResultDto result) {
        for (int i = 0; i < result.getNumberOfCars(); i++) {
            System.out.println(result.printResultByCar(i));
        }
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
