package racing;

import java.util.List;

public class ResultView {

    private static final String outputRacing = "-";
    public static void outputPrint(List<Integer> racingData) {

        for (Integer countRacing : racingData) {
            System.out.println(addString(countRacing));
        }
        System.out.println(" ");
    }

    public static String addString(Integer count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += outputRacing;
        }

        return result;
    }
}
