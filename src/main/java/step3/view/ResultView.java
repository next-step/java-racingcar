package step3.view;

import step3.domain.RacingCar;
import step3.domain.Car;

import java.util.Map;

public class ResultView {

    public static void gameResult() {
        System.out.println("게임 결과");
    }

    public static void carRace(Map<Integer, Car> carInfoMap, int racingCarNumber, int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            for (int j = 1; j <= racingCarNumber; j++) {
                Car racingCar = carInfoMap.get(j);
                String carState = racingCar.getMileAge();
                System.out.println(play(racingCar, j, carState, carInfoMap));
            }
            System.out.println();
        }
    }

    public static String play(Car racingCar, int j, String carState, Map<Integer, Car> carInfoMap ) {
        if (racingCar.getCarId() == j) {
            int randomCondition = RacingCar.getAccelateNumber();
            carState += RacingCar.racing(racingCar, randomCondition);

            racingCar.setMileAge(carState);
            carInfoMap.put(racingCar.getCarId(), racingCar);
        }
        return carState;
    }


}
