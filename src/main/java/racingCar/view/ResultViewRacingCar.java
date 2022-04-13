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

        // TODO
        // 리팩토링 필요
        // CarStadium에서 우승자를 찾아야하는게 맞을듯
        int max = 0;
        int j;
        for(j = 0; j < list.size(); ++j) {
            int distance = list.get(j).getDistance().length();
            if (distance > max) {
                max = distance;
            }
        }

        for(j = 0; j < list.size(); ++j) {
            Car car = list.get(j);
            if (max == car.getDistance().length()) {
                System.out.print(car.getName() + ", ");
            }
        }
        System.out.print("가 최종 우승했습니다");
        System.out.println();
        //


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
        //TODO view에서 자동차를 move하는게 맞나???
        car.move(CarStadium.extractRandomNumber());
        System.out.println(car.getDistance());
    }
}
