package view;

public class ResultView {
    private static final String RESULT_PREFIX = "실행 결과";

    public void print(String result) {
        System.out.println(RESULT_PREFIX);
        System.out.println(result);
    }
}
