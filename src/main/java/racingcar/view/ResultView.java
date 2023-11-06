package racingcar.view;

import java.util.List;

public class ResultView {

    public static void printResultStart() {
        System.out.println("\n실행 결과");
    }

    public static void print(List<String> results) {
        for (String result: results) {
            System.out.println(result);
        }

        System.out.println();
    }
}
