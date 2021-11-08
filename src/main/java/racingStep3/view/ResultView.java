package racingStep3.view;

import racingStep3.domain.RacingCar;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";

    public static void print(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            String carPosition = printCar(car);
            System.out.println(carPosition);
        }
    }

    public static String printCar(RacingCar car) {
        int value = car.getLocation();
        String result = "-";

        for(int i = 0; i < value; i++) {
            result += DASH;
        }

        return result;
    }
}
