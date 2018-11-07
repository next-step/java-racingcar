package racing.view;

import racing.domain.Car;
import racing.utils.CarRacingUtils;
import racing.msg.Winner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Result {

    private Result() {
    }

    public static void positionPrint(final List<Car> cars) {
        cars.forEach(Result::positionCalculator);
        System.out.println();
    }

    private static void positionCalculator(final Car car) {

        final StringBuilder sb = new StringBuilder();

        sb.append(car.getName());
        sb.append(" ");
        sb.append(":");
        sb.append(" ");

        IntStream.range(0, car.getPosition()).mapToObj(i -> "-").forEachOrdered(sb::append);

        sb.append("\n");

        System.out.print(sb.toString());
    }

    public static void printWinner(final List<Car> cars) {
        System.out.print(addACommaToWinnerName(cars));
        System.out.print(Winner.SUBFIX);
    }

    private static String addACommaToWinnerName(final List<Car> cars) {
        return CarRacingUtils.findWinnders(cars).stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
