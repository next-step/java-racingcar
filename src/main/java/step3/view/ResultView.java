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
            int carPosition = car.getPosition();

            boolean raceResult = RacingCar.receStart(car, i);
            carPosition += RacingCar.updatePosition(raceResult);
            String mileAge = printMovement(carPosition);

            car = new RacingCar(car.getCarId(), carPosition);
            carInfoMap.put(car.getCarId(), car);

            System.out.println(mileAge);
        }
        System.out.println();
    }



    public static String printMovement(int position) {
        String mileAge = "";
        for (int i = 0; i < position; i++) {
            mileAge += ACCELATE_SIGN;
        }
        return mileAge;
    }

}
