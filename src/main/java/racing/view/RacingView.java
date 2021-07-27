package racing.view;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {

    private static final String MOVE_TEXT = "-";

    static void printMoveLine(Car car) {
        System.out.print(String.format("%s : ", car.getCarInfo()));
        for (int i=0; i<car.totalDistance(); i++) {
            System.out.print(MOVE_TEXT);
        }
        System.out.println("");
    }

    public static void printCarMove(Racing racing) {
        racing.participants()
                .carList()
                .stream()
                .forEach(car -> printMoveLine(car));
        System.out.println("");
    }

    public static void printWinner(List<Car> cars) {
        //pobi, honux가 최종 우승했습니다.c
        String message = cars.stream().map(car -> car.getCarInfo()).collect(Collectors.joining(","))
                +"가 최종 우승했습니다.";

        System.out.println(message);
    }


}
