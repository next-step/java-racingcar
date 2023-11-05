package racingCar;

import java.util.Random;

public class Racing {
    private static int carCount;
    private static int roundCount;
    private static Car[] cars;

    public static final int MINIMUM_CAR_COUNT = 2;
    public static final int MINIMUM_ROUND_COUNT = 1;


    public Racing(int inputCarCount, int inputRoundCount) {
        carCount = inputCarCount;
        roundCount = inputRoundCount;

        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public static boolean holdPossible() {
        if (carCount < MINIMUM_CAR_COUNT || roundCount < MINIMUM_ROUND_COUNT) {
            return false;
        }
        return true;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public static void main(String[] args) {
        Racing racing = new Racing(InputView.carCount(), InputView.roundCount());

        //개최조건 미 충족시 종료
        if (!holdPossible()) {
            ResultView.noRace();
            return;
        }

        //경주시작
        ResultView.raceStart();
        for (int i = 0; i < roundCount; i++) {
            for (int j = 0; j < carCount; j++) {
                Random random = new Random();
                cars[j].moveAttempt(random.nextInt(10));
                ResultView.positionPrint(cars[j].getCurrentPosition());
            }
            ResultView.roundFinish();
        }
    }


}
