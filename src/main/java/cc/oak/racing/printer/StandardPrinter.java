package cc.oak.racing.printer;

public final class StandardPrinter implements Printer<String> {
    @Override
    public void print(String source) {
        System.out.print(source);
    }
}
