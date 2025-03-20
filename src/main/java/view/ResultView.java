package view;

public class ResultView {
    public static void printCurrentPosition(int position) {
        printResult("-".repeat(position));
    }

    public static void printResult(String message) {
        System.out.println(message);
    }
}