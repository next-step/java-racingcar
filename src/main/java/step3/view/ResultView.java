package step3.view;

import step3.domain.RacingCar;
import step3.domain.Car;

import java.util.Map;

public class ResultView {

    private static final String GAME_RESULT = "게임 결과";
    private static String ACCELATE_SIGN = "-";
    private static String BRAKE_SIGN = "";

    public static void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void carRace(Map<Integer, Car> carInfoMap, int racingCarNumber, int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            for (int j = 1; j <= racingCarNumber; j++) {
                Car car = carInfoMap.get(j);
                String mileAge = car.getMileAge();
                System.out.println(play(car, j, mileAge));
            }
            System.out.println();
        }
    }

    public static String play(Car racingCar, int j, String mileAge) {
        if (racingCar.getCarId() == j) {
            int raceCondition = RacingCar.raceCondition();
            mileAge += racingCar.move(raceCondition, RacingCar.MOVEMENT_POLICY);

            racingCar.setMileAge(mileAge);
        }
        return mileAge;
    }


}
