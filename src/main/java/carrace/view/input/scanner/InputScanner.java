package carrace.view.input.scanner;

public interface InputScanner<T> {
    T scan();

    T repeatScan(String message);
}
