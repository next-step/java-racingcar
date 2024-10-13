package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void main(String[] args) {
        UserInput userInput = InputView.readInput();

        System.out.println("실행 결과");
        start(userInput.getTotalCars(), userInput.getTotalRacingCounts());

    }

    public static int start(int totalCars, int totalRacingCounts) {
        int result = 0;

        List<RacingCar> racingCars = readyRacingCarsList(totalCars);

        for (int i = 0; i < totalRacingCounts; i++) {
            result += racing(racingCars);
            ResultView.display(racingCars);
        }

        return result;
    }

    private static List<RacingCar> readyRacingCarsList(int totalCars) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < totalCars; i++) {
            racingCars.add(new RacingCar(new Operator()));
        }
        return racingCars;
    }

    private static int racing(List<RacingCar> racingCars) {
        int result = 0;
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
            result++;
        }
        return result;
    }
}
