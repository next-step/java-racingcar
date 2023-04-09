package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static String CAR_START_POSITION = "";

    public static void gameStart(int numberOfCars, int countOfGames) {

        List<Car> carList = createCars(numberOfCars);

        System.out.println("실행 결과");

        for(int i = 0; i < countOfGames; i++) {
            moveCar(carList);
        }
    }

    public static List<Car> createCars(int cars) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            carList.add(new Car(CAR_START_POSITION));
        }

        return carList;
    }

    private static void moveCar(List<Car> cars) {

        ResultView resultView = new ResultView();

        for(Car car : cars) {
            car.moveCar(generateRandomNumber());

            resultView.resultGame(car.getPosition());
        }

        System.out.println();
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(10);
    }
}
