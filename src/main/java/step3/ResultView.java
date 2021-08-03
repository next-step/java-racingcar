package step3;

import java.util.Arrays;

public class ResultView {

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(int[] gameResults) {

        Arrays.stream(gameResults).forEach((result) -> printOneResult(result));

        System.out.println();
    }

    private static void printOneResult(int result) {

        for(int i = 0; i < result; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

}
