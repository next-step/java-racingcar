package carracing;

import carracing.domain.Game;
import carracing.domain.car.Cars;
import carracing.view.InputView;
import carracing.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String arg[]) throws CloneNotSupportedException {
        System.out.println("==== start car racing ====");

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        /* 사용자 입력받기 */
        Game game = new Game(inputView.getInputCarNames(), inputView.getInputTryCount());

        /* 게임 시작 */
        List<Cars>  listOfList = game.start();

        /* 게임결과 출력 */
        outputView.getResultView(listOfList);

        /* 우승자 출력 */
        Cars completedCars = new Cars(game.getCars());
        outputView.viewWinner(completedCars.getWinner());
    }
}
