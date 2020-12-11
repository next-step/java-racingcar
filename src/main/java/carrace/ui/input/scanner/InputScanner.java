package carrace.ui.input.scanner;

public interface InputScanner<T> {
    T scan();

    T repeatScan(String message);
}
