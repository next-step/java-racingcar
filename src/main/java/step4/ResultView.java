package step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsMove(List<Car> cars) {
        cars.stream()
                .map(car -> getNameAndMoves(car))
                .forEach(System.out::println);

        System.out.println();
    }

    private static String getNameAndMoves(Car car) {
        String name = car.getName();
        String stringCarsMove = getStringCarsMove(car.getPosition());

        return name + " : " + stringCarsMove;
    }

    private static String getStringCarsMove(int index) {
        return IntStream.range(0, index)
                .mapToObj(moveCount -> "-")
                .collect(Collectors.joining());
    }

    public static void printWinner(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
