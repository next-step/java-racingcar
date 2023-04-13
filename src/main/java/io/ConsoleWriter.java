package io;

public class ConsoleWriter {
    public static void write(ResultView resultView) {
        resultView.printAll();
    }

    public static void writeHeader() {
        System.out.println("실행 결과");
    }

    private ConsoleWriter() {
    }
}
