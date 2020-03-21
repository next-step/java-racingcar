package racingcar.ui;

public class ResultView {

    private final String renderingView;

    public ResultView(String renderingView) {
        this.renderingView = renderingView;
    }

    public void print() {
        System.out.printf("실행 결과\n%s", renderingView);
    }
}
