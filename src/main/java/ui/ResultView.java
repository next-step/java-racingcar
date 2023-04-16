package ui;

import car_racing.Car;

import java.util.List;

public class ResultView {
    public static void printMovingOfCars(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getMoveCount()));
        }
    }

    public static void printWinCar(List<Car> cars){
        for (Car car : cars) {
            System.out.print(car.getName() + ",");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
