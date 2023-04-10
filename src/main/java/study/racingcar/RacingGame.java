package study.racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {

    public static void gameStart(List<Car> carList, int countOfGames) {

        System.out.println("실행 결과");

        for(int i = 0; i < countOfGames; i++) {
            moveCar(carList);
        }
    }

    private static void moveCar(List<Car> cars) {

        ResultView resultView = new ResultView();

        for(Car car : cars) {
            car.moveCar(generateRandomNumber());

            resultView.resultGame(car.getPosition());
        }

        resultView.emptyLine();
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(10);
    }
}
