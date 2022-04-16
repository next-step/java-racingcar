package carracing;

import java.util.List;

public class GamePlay {
    public static void main(String[] args) {
        int countOfCars = InputView.inputCountofCars();
        int tryCount = InputView.inputTryCount();

        List<RacingCar> cars = RacingGame.initRacingCars(countOfCars);
        play(tryCount, cars);
    }

    private static void play(int tryCount, List<RacingCar> cars) {
        System.out.println("실행 결과");
        for(int i = 0; i < tryCount; i++) {
            RacingGame.racing(cars);
            ResultView.printRacingCarsRoutes(cars);
            System.out.println();
        }
    }
}
