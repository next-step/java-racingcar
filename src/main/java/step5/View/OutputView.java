package step5.View;


import step5.domain.Car;
import step5.domain.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    Cars cars = new Cars();
    public static void printStart() {
        System.out.println("실행결과");
    }

    public static void printCarMove(Cars cars) {
        List<Car> carMoves = cars.getCars();
        for (Car car : carMoves) {
            System.out.println(car.getName() + ":" + replacePositionToString(car.getPosition()));
        }
    }

    public void printWinner(List<Car> roundWinnerList) {

        Map<String, List<Car>> winner = roundWinnerList.stream()
                .collect(Collectors.groupingBy(Car::getName));

        String winners = winner.keySet().stream()
                                .collect(Collectors.joining(","));


        System.out.println(winners+"가 최종 우승하였습니다.");

    }

    private static String replacePositionToString(int position) {
        String replacePosition ="";
        for (int i = 0; i < position; i++) {
            replacePosition += "-";
        }
        return  replacePosition;
    }
}
