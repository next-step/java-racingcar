package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printTurnResult(List<Car> cars) {
        for (Car car : cars) {
            printEachCarResult(car);
        }
    }

    public void printEachCarResult(Car car) {
        System.out.println(car.getName() + " : " + car.getSteps());
    }

    public void printFinalResult(List<Car> winners) {
        System.out.println("최종 우승자 : ");

        for (Car winner : winners) {
            System.out.println(winner.getName());
        }
    }

}
