package racingcar;

import java.util.Random;

public class RacingSimulator {

    private static Random random = new Random();

    public static void main(String[] args) {


        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = MyNumberScanner.readInput();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = MyNumberScanner.readInput();

        simulate(carCount, tryCount);

    }

    private static void simulate(int carCount, int tryCount) {

        RacingCar[] racingCars = initRacingCars(carCount);

        printResult();

        for (int i = 0; i < tryCount; i++) {

            // 각 자동차별 action()
            eachCarAction(carCount, racingCars);

            newline();
        }
    }

    private static void eachCarAction(int carCount, RacingCar[] racingCars) {
        for (int i = 0; i < carCount; i++){
            racingCars[i].action(getRandomNumber());
        }
    }

    private static void newline() {
        System.out.println();
    }

    private static RacingCar[] initRacingCars(int carCount) {
        RacingCar[] racingCars = new RacingCar[carCount];
        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new RacingCar();
        }
        return racingCars;
    }

    private static void printResult() {
        System.out.println("실행 결과");
    }

    private static int getRandomNumber() {
        return random.nextInt(10);
    }
}