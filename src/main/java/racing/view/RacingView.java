package racing.view;

import static racing.common.Script.*;

import racing.controller.RacingController;
import racing.vo.Cars;
import racing.vo.GameMakingInfo;

public class RacingView {
    protected InputView inputView;
    protected ResultView resultView;
    protected RacingController controller;
    
    public RacingView() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }
    
    public void requestGameInfo() {
        final GameMakingInfo gameMakingInfo = new GameMakingInfo(
            printCarQuestionAndGetAnswer(), printTimeQuestionAndGetAnswer()
        );
        controller.makeNewGame(gameMakingInfo);
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
    
    public void printMovingStatus(Cars cars) {
        resultView.printMovingStatus(cars);
    }
    
    public void setController(RacingController controller) {
        this.controller = controller;
    }
}
