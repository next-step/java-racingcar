package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<List<Car>> carList) {
        for(List<Car> cars : carList){
            printCars(cars);
            System.out.println();
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString() + " : " + printLocationMark(car));
        }
    }

    public static void printGameResult(List<Car> cars) {
        System.out.println(cars.toString() + "가 최종 우승했습니다.");
    }

    private static String printLocationMark(Car car) {
        String mark = "-";
        return mark.repeat(car.getCarLocation());
    }
}
