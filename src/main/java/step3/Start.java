package step3;

import step3.util.InputUtils;
import step3.vehicle.Cars;
import step3.view.ResultView;

public class Start {
    public static void main(String[] args) {
        Cars cars = new Cars(InputUtils.inputCarView());
        ResultView resultView = new ResultView();
        PlayGame play = new PlayGame(cars.getCars(),resultView);
        play.gameStart(InputUtils.inputMoveView());
    }

}
