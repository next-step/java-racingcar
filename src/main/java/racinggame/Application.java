package racinggame;

import java.util.List;
import racinggame.domain.Racing;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        Racing game = new Racing();
        game.registerCar(carNames);
        while (tryNumber > 0) {
            game.race();
            ResultView.printRace(game.getCarInfo());
            tryNumber--;
        }

        ResultView.printWinners(game.getCarInfo());
    }

}
