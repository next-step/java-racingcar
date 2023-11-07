package study.step4;

public class Racing {

    public void start() {
        Rule rule = prepare();
    }

    private Rule prepare() {
        return InputView.request();
    }
}
