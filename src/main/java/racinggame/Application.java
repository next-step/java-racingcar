package racinggame;

import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.GameInit;
import racinggame.domain.PlayRacingGame;

public class Application {

    public static void main(String[] args) {
        GameInit gameInit = new GameInit();
        String[] carNames = gameInit.inputPlayerName();
        int playGameNumber = gameInit.inputTryNumber();

        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(carNames);

        PlayRacingGame playRacingGame = new PlayRacingGame();
        System.out.println("실행 결과");
        for (; playGameNumber > 0; playGameNumber--) {
            playRacingGame.move(carList);
            playRacingGame.printCarsLocation(carList);

        }
        List<String> winner = playRacingGame.findWinner(carList);
        playRacingGame.printWinner(winner);
    }


}
