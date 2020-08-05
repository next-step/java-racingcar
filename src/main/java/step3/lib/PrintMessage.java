package step3.lib;

public class PrintMessage {

    private PrintMessage() {}

    public static void print(String message) {
        System.out.printf(message);
    }

    public static void print(String format, String message) {
        System.out.printf(format, message);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
