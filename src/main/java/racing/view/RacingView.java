package racing.view;

import static racing.common.Script.*;
import racing.vo.Cars;

public class RacingView {
    private InputView inputView;
    private ResultView resultView;
    
    public RacingView() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }
    
    public String printCarQuestionAndGetAnswer() {
        inputView.printQuestion(CAR_NAMES_QUESTION.getMessage());
        return inputView.requestInputString();
    }
    
    public int printTimeQuestionAndGetAnswer() {
        inputView.printQuestion(TIME_COUNT_QUESTION.getMessage());
        return inputView.requireInputInteger();
    }
    
    public void printWinner(String winnerNames) {
        resultView.printWinners(winnerNames);
    }
    
    public void printMovingStatus(Cars cars) {
        resultView.printMovingStatus(cars);
    }
}
