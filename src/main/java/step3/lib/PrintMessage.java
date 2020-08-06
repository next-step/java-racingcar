package step3.lib;

/**
 * 출력에 관한 Util 클래스
 */
public class PrintMessage {

    private PrintMessage() {}

    /**
     * 메세지 출력
     * @param message
     */
    public static void print(String message) {
        System.out.printf(message);
    }

    /**
     * 메세지 출력
     * @param format
     * @param message
     */
    public static void print(String format, String message) {
        System.out.printf(format, message);
    }

    /**
     * 메세지 출력
     */
    public static void println() {
        System.out.println();
    }

    /**
     * 메세지 출력
     * @param message
     */
    public static void println(String message) {
        System.out.println(message);
    }
}
