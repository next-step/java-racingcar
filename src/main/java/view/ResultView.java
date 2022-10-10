package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printRacingResult(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + distanceToVisual(car))
        );
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        System.out.println(String.join(",", cars.stream().map(Car::getName).collect(Collectors.toList())) + "가 최종 우승했습니다.");
    }

    private String distanceToVisual(Car car) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            result.append("-");
        }
        return result.toString();
    }


}
