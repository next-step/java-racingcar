package racing.views;

import java.util.Scanner;

public abstract class InputView<T> extends View<T, String> {
    final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public final T show(String message) {
        System.out.println(message);
        return input();
    }

    abstract protected T input();
}
