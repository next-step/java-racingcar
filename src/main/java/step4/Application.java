package step4;

import step4.controller.PlayGame;
import step4.util.InputUtils;
import step4.domain.Cars;
import step4.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(InputUtils.inputCarNameView());
        ResultView resultView = new ResultView();
        PlayGame play = new PlayGame(cars, resultView);
        play.gameStart(InputUtils.inputMoveView());
    }

}
