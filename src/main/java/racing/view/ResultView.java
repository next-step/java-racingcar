package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DASH = "-";

    public static void init() {
        System.out.println("실행 결과");
    }

    public void result(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : " + DASH.repeat(car.getDistance()));
            System.out.println("");
        }
    }

    public void printWinner(List<Car> winnerCars) {
        System.out.println("");
        System.out.println(winnerCars
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(",")) + "가 최종 우승했습니다."
        );
    }
}
