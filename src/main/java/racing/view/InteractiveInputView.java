package racing.view;

import java.util.Scanner;

public abstract class InteractiveInputView<T> {

    private final String message;

    protected InteractiveInputView(String message) {
        this.message = message;
    }

    public T getUserInput() {
        System.out.println(this.message);

        Scanner scanner = new Scanner(System.in);
        return parse(scanner.next());
    }

    protected abstract T parse(String s);

}
