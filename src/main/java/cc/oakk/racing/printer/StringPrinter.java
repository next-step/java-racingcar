package cc.oakk.racing.printer;

public abstract class StringPrinter<T> implements Printer<T> {
    protected final Printer<String> stringPrinter;

    public StringPrinter() {
        this.stringPrinter = new StandardPrinter();
    }

    public StringPrinter(Printer<String> stringPrinter) {
        if (stringPrinter == null) {
            throw new IllegalArgumentException("stringPrinter is null!");
        }

        this.stringPrinter = stringPrinter;
    }
}
