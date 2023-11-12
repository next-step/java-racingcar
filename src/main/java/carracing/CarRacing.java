package carracing;

import static carracing.Race.raceStart;
import static carracing.ResultView.getResultComment;


public class CarRacing {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.getInput();
        getResultComment();
        raceStart(inputView.carCnt, inputView.tryCnt);

    }
}