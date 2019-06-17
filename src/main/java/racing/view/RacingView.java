package racing.view;

import racing.vo.Cars;
import racing.common.Question;

public class RacingView {
    private InputView inputView;
    private ResultView resultView;
    
    public RacingView() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }
    
    public String printCarQuestionAndGetAnswer() {
        inputView.printQuestion(Question.CAR_NAMES.getQuestion());
        return inputView.requestInputString();
    }
    
    public int printTimeQuestionAndGetAnswer() {
        inputView.printQuestion(Question.TIME_COUNT.getQuestion());
        return inputView.requireInputInteger();
    }
    
    public void printWinner(String winnerNames) {
        resultView.printWinners(winnerNames);
    }
    
    public void printMovingStatus(Cars cars) {
        resultView.printMovingStatus(cars);
    }
}
