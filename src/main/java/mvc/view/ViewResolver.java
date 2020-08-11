package mvc.view;

import mvc.domain.dto.GameInputs;
import mvc.domain.dto.GameResults;
import mvc.view.in.InputView;
import mvc.view.out.ResultView;

public class ViewResolver {
    private final InputView inputView;
    private final ResultView resultView;

    private ViewResolver() {
        this.inputView = InputView.createInputView();
        this.resultView = ResultView.createResultView();
    }

    public GameInputs getGameInputs() {
        return this.inputView.getGameInputs();
    }

    public void printGameResult(GameResults results) {
        this.resultView.printGameResult(results);
    }

    public static ViewResolver createViewResolver() {
        return new ViewResolver();
    }
}
