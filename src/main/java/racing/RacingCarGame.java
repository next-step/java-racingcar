package racing;

import java.util.Scanner;

public class RacingCarGame {

    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int totalCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int totalRacingCounts = scanner.nextInt();

        start(totalCars, totalRacingCounts);

    }

    public static int start(int totalCars, int totalRacingCounts) {
        int result = 0;

        RacingCar[] racingCars = readyRacingCars(totalCars);

        for (int i = 0; i < totalRacingCounts; i++) {
            result += racing(racingCars);
        }

        return result;
    }

    private static RacingCar[] readyRacingCars(int totalCars) {
        RacingCar[] racingCars = new RacingCar[totalCars];
        for (int i = 0; i < totalCars; i++) {
            racingCars[i] = new RacingCar();
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
