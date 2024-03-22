package ui;

import racing.Car;
import racing.RacingCars;

import java.util.List;

public class ResultView {

    public static void showRaceResult(RacingCars racingCars, int tryCount) {
        if (tryCount == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        List<Car> racedCarList = racingCars.getCarList();

        for (int i = 0; i < racedCarList.size(); i++) {
            showCarLocation(racedCarList.get(i));
            System.out.println();
        }
        System.out.println();
    }

    private static void showCarLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }

    public static void showRaceWinner(RacingCars racingCars) {
        StringBuilder sb = new StringBuilder();
        List<Car> winCarList = racingCars.getWinCarList();
        for (int i = 0; i < winCarList.size(); i++) {
            Car winnerCar = winCarList.get(i);
            sb.append(winnerCar.getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}
