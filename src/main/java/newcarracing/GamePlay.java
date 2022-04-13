package newcarracing;

import java.util.List;

public class GamePlay {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarsWithName();
        int tryCount = InputView.inputTryCount();

        List<RacingCar> cars = RacingGame.initRacingCars(carNames);
        play(tryCount, cars);
    }

    private static void play(int tryCount, List<RacingCar> cars) {
        System.out.println("실행 결과");
        for(int i = 1; i <= tryCount; i++) {
            RacingGame.racing(cars);
            ResultView.printRacingCarsRoutes(cars);
            System.out.println();
        }
        ResultView.printWinners(RacingGame.createWinnersList(cars));
    }
}