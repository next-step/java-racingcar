package racing;

public class StringInputView extends InputView<String> {
    @Override
    protected String input() {
        return scanner.nextLine();
    }
}
