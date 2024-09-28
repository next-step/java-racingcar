package racingcar;

public class ResultView {

    public static void printResult(String[] textArray) {
        for (String text : textArray) {
            if (text != null) {
                System.out.println(text);
            }
        }
        System.out.println();
    }
}
