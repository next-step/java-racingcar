package racing;

import java.util.List;

public class RacingCarView {

    public static void viewRacingCar(List<Car> cars, int moveCnt) {

        for (int i = 0; i < moveCnt; i++) {

            for (int j = 0; j < cars.size(); j++) {

                System.out.print(cars.get(j).getName() + ": ");

                for (int k = 0; k < i + 1; k++) {
                    if (cars.get(j).getMoveList().get(k) == 1) {
                        System.out.print("-");
                    }
                }

                System.out.println();
            }

            System.out.println();

        }
    }

    public static void viewRacingCarWinners(List<Car> cars) {
        String winners = "";
        for (Car car : cars) {
            winners += car.getName() + ", ";
        }
        System.out.println(winners.substring(0, winners.length() - 2) + "가 최종 우승했습니다.");
    }
}
