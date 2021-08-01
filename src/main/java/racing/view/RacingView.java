package racing.view;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {

    private static final String MOVE_TEXT = "-";
    private static final String WIN_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printCarMove(List<Car> cars) {
        cars.stream()
                .forEach(car -> printMoveLine(car));
        System.out.println("");
    }

    static void printMoveLine(Car car) {
        System.out.print(String.format("%s : ", car.carName()));
        for (int i=0; i<car.totalDistance(); i++) {
            System.out.print(MOVE_TEXT);
        }
        System.out.println("");
    }

    public static void printWinner(List<Car> cars) {
        String message = String.format(WIN_MESSAGE,
                cars.stream()
                .map(car -> car.carName())
                .collect(Collectors.joining(",")));

        System.out.println(message);
    }


}
