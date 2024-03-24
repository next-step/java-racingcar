package ui;

import racing.Car;
import racing.RacingCars;

import java.util.Iterator;
import java.util.Set;

public class ResultView {

    public static void showRaceResult(RacingCars racingCars, int tryCount) {
        if (tryCount == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        Set<Car> racingCarsSet = racingCars.getCarSet();
        Iterator<Car> iterator = racingCarsSet.iterator();
        while (iterator.hasNext()) {
            showCarLocation(iterator.next());
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
        Iterator<Car> winCarIterator = racingCars.getWinCarList().iterator();
        while (winCarIterator.hasNext()) {
            sb.append(winCarIterator.next().getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

}
