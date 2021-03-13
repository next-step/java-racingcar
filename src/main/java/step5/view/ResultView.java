package step5.view;



import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsMove(Cars cars) {
        List<Car> carsMoves = cars.getCars();
        carsMoves.stream()
                .map(car -> getNameAndMoves(car))
                .forEach(System.out::println);

        System.out.println();
    }

    private static String getNameAndMoves(Car car) {
        String name = car.getName().getName();
        String stringCarsMove = getStringCarsMove(car.getPosition().getPosition());

        return name + " : " + stringCarsMove;
    }

    private static String getStringCarsMove(int index) {
        return IntStream.range(0, index)
                .mapToObj(moveCount -> "-")
                .collect(Collectors.joining());
    }

    public static void printWinner(Winners winners) {
        List<Car> cars = winners.getWinners();
        String winnersNames = cars.stream()
                .map(car -> car.getName().getName())
                .collect(Collectors.joining(", "));

        System.out.println(winnersNames + "가 최종 우승했습니다.");
    }
}
