package step_2;

public class Calculator {

    private final Splitter splitter;

    public Calculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int sum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return splitter.split().andThen(value -> new Numbers(value).sum()).apply(text);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}