package carracing;

import java.util.List;

public class GamePlay {
    public static void main(String[] args) {
        int countOfCars = InputView.inputCountofCars();
        int tryCount = InputView.inputTryCount();

        List<RacingCar> carList = RacingGame.initRacingCars(countOfCars);
        play(tryCount, carList);
    }

    private static void play(int tryCount, List<RacingCar> carList) {
        System.out.println("실행 결과");
        for(int i = 0; i < tryCount; i++) {
            RacingGame.racing(carList);
            ResultView.printRacingCarsRoutes(carList);
            System.out.println();
        }
    }
}
