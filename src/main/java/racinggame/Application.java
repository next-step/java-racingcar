package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.GameInit;
import racinggame.domain.Winners;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {
        GameInit gameInit = new GameInit();
        ResultView resultView = new ResultView();
        String[] carNames = gameInit.inputPlayerName();
        Cars cars = new Cars(carNames);

        int playGameNumber = gameInit.inputTryNumber();
        System.out.println("실행 결과");
        for (; playGameNumber > 0; playGameNumber--) {
            cars.move();
            resultView.printCarsLocation(cars);

        }

        final int maxLocation = cars.findMaxLocation();
        Winners winners = new Winners(cars, maxLocation);
        resultView.printWinner(winners);
    }

}
