package racing.view;

import static racing.common.Script.*;

import racing.controller.RacingController;
import racing.domain.Cars;
import racing.vo.GameMakingInfo;

import java.util.List;

public class RacingView {
    protected InputView inputView;
    protected ResultView resultView;
    protected RacingController controller;
    
    public RacingView() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }
    
    public GameMakingInfo requestGameInfo() {
        return new GameMakingInfo(
            printCarQuestionAndGetAnswer(), printTimeQuestionAndGetAnswer()
        );
    }
    
    private String printCarQuestionAndGetAnswer() {
        inputView.printQuestion(CAR_NAMES_QUESTION.getMessage());
        return inputView.requestInputString();
    }
    
    private int printTimeQuestionAndGetAnswer() {
        inputView.printQuestion(TIME_COUNT_QUESTION.getMessage());
        return inputView.requireInputInteger();
    }
    
    public void printWinner(String winnerNames) {
        resultView.printWinners(winnerNames);
    }
    
    public void printMovingStatus(List<Cars> movingHistory) {
        resultView.printMovingStatus(movingHistory);
    }
    
    public void setController(RacingController controller) {
        this.controller = controller;
    }
}
