package racing.view;

import racing.Car;
import racing.CarRacer;
import racing.msg.Winner;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Result {

    private Result() {
    }

    public static void positionPrint(final List<Car> list) {
        list.forEach(Result::positionCalculator);
        System.out.println();
    }

    private static void positionCalculator(final Car car) {

        final StringBuilder sb = new StringBuilder();

        sb.append(car.getCarRacer().getName());
        sb.append(" ");
        sb.append(":");
        sb.append(" ");

        IntStream.range(0, car.getPosition()).mapToObj(i -> "-").forEachOrdered(sb::append);

        sb.append("\n");

        System.out.print(sb.toString());
    }

    public static void printWinner(final List<Car> list) {
        final Optional<Car> max = list.stream().max(Comparator.comparing(Car::getPosition));
        max.ifPresent(car -> System.out.print(winnerCalculator(list, car)));
        System.out.print(Winner.SUBFIX);
    }

    private static String winnerCalculator(final List<Car> list, final Car car) {
        return list.stream()
                .filter(c -> c.getPosition() == car.getPosition())
                .map(c -> c.getCarRacer().getName())
                .collect(Collectors.joining(", "));
    }

}
