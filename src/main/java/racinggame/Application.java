package racinggame;

import java.util.List;
import java.util.Random;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.GameInit;
import racinggame.domain.PlayRacingGame;
import racinggame.domain.Winner;

public class Application {

    public static void main(String[] args) {
        GameInit gameInit = new GameInit();
        String[] carNames = gameInit.inputPlayerName();
        int playGameNumber = gameInit.inputTryNumber();
        Random random=new Random();

        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();

        PlayRacingGame playRacingGame = new PlayRacingGame();
        System.out.println("실행 결과");
        for (; playGameNumber > 0; playGameNumber--) {
            List<Integer> randomNumberList = playRacingGame.makeRandomNumbers(carList.size(),random);
            cars.move(randomNumberList);
            playRacingGame.printCarsLocation(carList);

        }
        List<Winner> winnerList = playRacingGame.findWinner(carList);
        playRacingGame.printWinner(winnerList);
    }


}
