package racing.view;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {

    private static final String WIN_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printCarMove(Racing racing) {
        racing.getCarMoveLines()
                .stream()
                .forEach(line -> System.out.println(line));
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
