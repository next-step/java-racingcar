package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printRacingResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printResultTitle(){
        System.out.println("실행 결과");    }
}
