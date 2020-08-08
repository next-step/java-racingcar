package step3.view;

import step3.domain.Car;
import step3.domain.RacingCar;

import java.util.Map;

public class ResultView {

    private static final String GAME_RESULT = "게임 결과";
    public static String ACCELATE_SIGN = "-";
    public static String BRAKE_SIGN = "";

    public static void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void carRace(Map<Integer, Car> carInfoMap, int racingCarNumber, int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            participatingCars(carInfoMap, racingCarNumber);
        }
    }

    public static void participatingCars(Map<Integer, Car> carInfoMap, int racingCarNumber) {
        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = carInfoMap.get(i);
            String mileAge = car.getMileAge();

            boolean raceResult = RacingCar.receStart(car, i);
            mileAge += printMovement(raceResult);
            car.setMileAge(mileAge);

            System.out.println(mileAge);
        }
        System.out.println();
    }

    public static String printMovement(boolean raceResult) {
        if (raceResult) {
            return ACCELATE_SIGN;
        }
        return BRAKE_SIGN;
    }



}
