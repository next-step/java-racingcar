package racingcar.mainapp;

import racingcar.domain.CarCollection;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        InputView in = new InputView();
        in.inputSetting();
        RacingGame game = new RacingGame(in.getCarNames(), in.getTime());
        CarCollection carCollection = new CarCollection(game.getCars());

        for(int i = 0; i < game.getTime(); i++){
            ResultView.result(game.move());
        }
        ResultView.printWinner(carCollection.decideWinner(game.getCars()));
    }
}
