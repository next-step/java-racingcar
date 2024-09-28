package racingcar;

import java.util.Random;

public class RacingCar {
    private static int loop;
    private static int carCount;
    private static String[] result;

    private static Random random = new Random();

    public static void startRace() {
        carCount = InputView.inputCarCount();
        loop = InputView.inputLoop();

        race(carCount, loop);
    }

    static void race(int carCount, int loop){
        result = new String[carCount];

        System.out.println("실행결과");
        for (int loopIndex = 0; loopIndex < loop; loopIndex++) {
            for (int carIndex = 0; carIndex < carCount; carIndex++) {
                if (checkGreaterThanOrEqualToFour(generateRandomNumber())) result[carIndex] = run(result[carIndex]);
            }
            ResultView.printResult(result);
        }
    }

    static String run(String carResult) {
        if(carResult == null) carResult = "";
        return carResult + "-";
    }

    static int generateRandomNumber() {
        return random.nextInt(10);
    }

    static boolean checkGreaterThanOrEqualToFour(int number) {
        return number >= 4;
    }
}
