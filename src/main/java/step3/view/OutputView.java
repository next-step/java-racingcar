package step3.view;

public class OutputView {

    public static final String BANNER_STRING = "실행 결과";
    private String dashString;

    public OutputView() {
        System.out.println(BANNER_STRING);
    }

    public String getDashDistance(int value) {
        dashString = "";
        for (int i = 0; i < value; i++) {
            dashString += "-";
        }
        return dashString;
    }
}
