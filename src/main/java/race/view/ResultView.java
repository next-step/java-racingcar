package race.view;

public class ResultView {

    public static void printResult(int position) {
        StringBuilder result;
        result = new StringBuilder();
        result.append("-".repeat(Math.max(0, position)));
        System.out.println(result);
    }
}
