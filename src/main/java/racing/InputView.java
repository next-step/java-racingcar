package racing;

public class InputView {
    private String question;

    public InputView(String message) {
        question = message;
    }

    public int play() {
        System.out.println(question);

        return GameScanner.input();
    }
}
