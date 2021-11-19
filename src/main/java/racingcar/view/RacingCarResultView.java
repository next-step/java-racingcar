package racingcar.view;

import racingcar.domain.*;

import java.util.List;

public class RacingCarResultView {

    private static final String DASH = "-";

    public static void print(RacingCars cars) {

        List<RacingCar> carList = cars.getCars();
        for(int i = 0; i < carList.size(); i++) {
            String carPosition = printCar(carList.get(i));
            System.out.println(carPosition);
        }
        System.out.println();
    }

    public static String printCar(RacingCar car) {
        int value = car.getLocation();
        String result = car.getCarName().getName() + ": -";

        for(int i = 0; i < value; i++) {
            result += DASH;
        }

        return result;
    }

    public void printVictoryUser(String winners) {
        System.out.println(winners + "가 최종 우승했습니다!!");
    }

}
