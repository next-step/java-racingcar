package racingcar.view;

import racingcar.domain.GameResultData;
import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarResultView {

    private static final String DASH = "-";

    public static void print(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            String carPosition = printCar(car);
            System.out.println(carPosition);
        }
    }

    public static String printCar(RacingCar car) {
        int value = car.getLocation();
        String result = car.getCarName().getName() + ": -";

        for(int i = 0; i < value; i++) {
            result += DASH;
        }

        return result;
    }

    public void printVictoryUser(GameResultData result) {
        System.out.println(result.getVictoryUsers() + "가 최종 우승했습니다!!");
    }
}
