package view;

import domain.Car;
import domain.CarName;

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
        //로컬변수로 한번 받아서 처리하도록 변경
        List<String> winnerNames = cars.stream()
                .map(Car::getName)
                .map(CarName::getCarName)
                .collect(Collectors.toList());

        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

    private String distanceToVisual(Car car) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            result.append("-");
        }
        return result.toString();
    }


}
