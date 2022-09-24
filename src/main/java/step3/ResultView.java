package step3;

public class ResultView {

    public static final String RESULT_TEXT = "실행 결과";
    public static final String FORWARD_TEXT = "-";
    public static final String END_TEXT = "";

    public static void resultPrint(int num){
        System.out.println(FORWARD_TEXT.repeat(num));
    }

    public static void start() {
        System.out.println(RESULT_TEXT);
    }

    public static void cycleEnd() {
        System.out.println(END_TEXT);
    }
}
