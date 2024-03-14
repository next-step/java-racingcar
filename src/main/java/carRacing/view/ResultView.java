package carRacing.view;

import car.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public ResultView() {
    }

    public void showCardRacingResultByResultList(List<List<Integer>> resultList, String locationString) {
        System.out.println("실행결과");
        for (List<Integer> integers : resultList) {
            System.out.println("###########");
            showCardRacingEachRound(locationString, integers);
            System.out.println("###########");
        }
    }

    private void showCardRacingEachRound(String locationString, List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.println(getResultString(integer, locationString));
        }
    }

    private String getResultString(int stringCount, String stringStyle) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < stringCount; i++) {
            sb.append(getStringStyleString(stringStyle));
        }
        return sb.toString();
    }

    private String getStringStyleString(String stringStyle) {
        if (stringStyle.isBlank()) {
            return "-";
        }
        return stringStyle;
    }
}
