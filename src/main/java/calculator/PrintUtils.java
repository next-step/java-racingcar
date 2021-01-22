package calculator;

public class PrintUtils {
    public static void printInputRequest() {
        System.out.println(Constant.INPUT_REQUEST);
    }

    public static void printResultOutput(int result) {
        System.out.println(Constant.RESULT + result + Constant.FINAL_SENTENCE);
    }

    public static void printError(){
        System.out.println(Constant.INTERNAL_ERROR);
    }
}
