package carracing;

import carracing.domain.Game;
import carracing.domain.car.Car;
import carracing.view.InputView;
import carracing.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String arg[]) {
        System.out.println("==== start car racing ====");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Game game = new Game(inputView.getInputCarNames(), inputView.getInputTryCount());
        List<List<Car>>  listOfList = game.start();
        outputView.getResultView(listOfList);

        game.end();
    }
}
