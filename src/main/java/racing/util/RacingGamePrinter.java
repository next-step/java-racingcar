package racing.util;

public class RacingGamePrinter {
    private static final String END_MESSAGE_FORMAT = "실행 결과";

    public static void print(String string) {
        System.out.println(END_MESSAGE_FORMAT);
        System.out.print(string);
    }
}
