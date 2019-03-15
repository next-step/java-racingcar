package racing;

import java.util.List;

public class RacingGameMain {
    public static void main(String args[]) {

        RacingGame racingGame = new RacingGame(InputView.getNamesOfCars());
        List<Car> cars = null;

        int timeToTry = InputView.getTimeToTry();

        int time = 0;
        while(time < timeToTry) {
            cars = racingGame.race();
            ResultView.printResult(cars);
            time++;
        }

        List<Car> winners = racingGame.getWinner(cars);
        ResultView.printWinners(winners);

    }
}
