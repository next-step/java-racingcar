package racinggame;

import java.util.List;
import racinggame.domain.Racing;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarName();
        int tryNumber = InputView.getTryNumber();

        Racing game = new Racing();
        game.race(carNames, tryNumber);

        ResultView.printCars(game.getResult());
        ResultView.printWinners(game.getCarInfo());
    }

}
