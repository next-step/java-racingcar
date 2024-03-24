package step5.util;

public class MyPrinter {
    private MyPrinter() {
    }

    public static void printLine(String text) {
        System.out.println(text);
    }

    public static void print(char character) {
        System.out.print(character);
    }

    public static void lineChange() {
        System.out.println();
    }

}
