package step3.view.output;

import step3.view.output.presenter.Presenter;

public class ResultView {
    private ResultView() {
        throw new AssertionError();
    }

    public static void print(final Presenter presenter) {
        Printer.print(presenter.present());
    }
}
