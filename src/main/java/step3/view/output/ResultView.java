package step3.view.output;

public class ResultView {
    private ResultView() {
        throw new AssertionError();
    }

    public static void print(final Presenter presenter) {
        Printer.print(presenter.present());
    }
}
