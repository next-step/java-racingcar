package racing;

import java.util.Scanner;

public class RacingCarGame {

    public static void main(String[] args) {
        UserInput userInput = InputView.readInput();

        System.out.println("실행 결과");
        start(userInput.getTotalCars(), userInput.getTotalRacingCounts());

    }

    public static int start(int totalCars, int totalRacingCounts) {
        int result = 0;

        RacingCar[] racingCars = readyRacingCars(totalCars);

        for (int i = 0; i < totalRacingCounts; i++) {
            result += racing(racingCars);
            ResultView.display(racingCars);
        }

        return result;
    }

    private static RacingCar[] readyRacingCars(int totalCars) {
        RacingCar[] racingCars = new RacingCar[totalCars];
        for (int i = 0; i < totalCars; i++) {
            racingCars[i] = new RacingCar(new Operator());
        }
        return racingCars;
    }

    private static int racing(RacingCar[] racingCars) {
        int result = 0;
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
            result++;
        }
        return result;
    }
}
