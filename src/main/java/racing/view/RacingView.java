package racing.view;

import racing.common.Question;

public class RacingView {
    private InputView inputView;
    private ResultView resultView;
    
    public RacingView(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
    
    public String printCarQuestionAndGetAnswer() {
        InputView.printQuestion(Question.CAR_NAMES.getQuestion());
        return InputView.requestInputString();
    }
    
    public int printTimeQuestionAndGetAnswer() {
        InputView.printQuestion(Question.TIME_COUNT.getQuestion());
        return InputView.requireInputInteger();
    }
}
