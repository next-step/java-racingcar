package cc.oakk.racing.view.printer;

public final class StandardPrinter implements Printer<String> {
    @Override
    public void print(String source) {
        System.out.print(source);
    }
}
