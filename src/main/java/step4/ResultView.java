package step4;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    private static int playTryTimes = 0;

    public static void viewResult(List<Car> cars) {

        System.out.println(++playTryTimes + " th Try.. ");
        for (Car car : cars) {
            printCurrentLocation(car);
        }

    }

    private static void printCurrentLocation(Car car) {
        System.out.println(car.getCarName() + "\t\t : " + new String(new char[car.getLocation()]).replace("\0", "-"));
    }

    public static void printWinner(List<Car> cars) {

        Optional<Car> max = cars.stream().max((o1, o2) -> (o1.getLocation() >= o2.getLocation()) ? 1 : -1);
        Stream<Car> ranked = cars.stream().filter(o -> o.getLocation() == max.get().getLocation());

        System.out.println(ranked.map(Car::getCarName).collect(Collectors.joining(",")) + "\t\t is(are) Winner(s). ");

    }


}
