package racingCar.view;

import racingCar.Car;
import racingCar.CarStadium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ResultViewRacingCar {

    private ResultViewRacingCar() {
    };

    public static void resultViewRacing() {
        System.out.println();
        System.out.println("실행결과");

        LinkedList<Car> list = CarStadium.getCars();
        int rounds = CarStadium.getRounds();

        for (int i = 0; i < rounds; ++i) {
            resultViewCarData(list);
        }

        resultViewWinners(list);
    }

    private static void resultViewCarData(List<Car> list) {

        for (int i = 0; i < list.size(); ++i) {
            resultViewCarName(list.get(i));
            resultViewCarDistance(list.get(i));
        }
        System.out.println();
    }

    private static void resultViewCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void resultViewCarDistance(Car car) {
        CarStadium.moveCar(car);

        System.out.println(car.getDistance());
    }

    private static void resultViewWinners(LinkedList<Car> list) {
        ArrayList<String> winners = CarStadium.getWinners(list);

        for (int i = 0; i < winners.size(); ++i) {
            resultViewWinners(winners, i);
        }

        System.out.print("가 최종 우승했습니다.");
        System.out.println();

    }

    private static void resultViewWinners(ArrayList<String> winners, int i) {
        if (i == 0) {
            System.out.print(winners.get(i));
            return;
        }
        System.out.print("," + winners.get(i));
    }
}
