package cc.oak.racing.printer;

public interface Printable<T> {
    void print(Printer<T> printer);
}
