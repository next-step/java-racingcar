package step3.view;

public class OutputView {

    public static final String BANNER_STRING = "실행 결과";

    public static String getDashDistance(int value) {
        String dashString = "";
        for (int i = 0; i < value; i++) {
            dashString += "-";
        }
        return dashString;
    }
}
