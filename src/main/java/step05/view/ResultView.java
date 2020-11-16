package step05.view;

import step05.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private final static String carKind = "-";
    private final static String delimiter = "";
    private final static String POST_WINNER_MESSAGE = "가 최종우승했습니다";
    private final static String RESULT_START_MESSAGE = "실행 결과";

    public static void printRace(List<Cars> raceSnapShop) {
        System.out.println(RESULT_START_MESSAGE);

        for (Cars cars : raceSnapShop) {
            printCarsPosition(cars);
        }
    }

    private static void printCarsPosition(Cars cars) {
        cars.getCars().forEach((car) -> {
            String result = car.getName().getName()
                    + " : "
                    + IntStream.range(0, car.getPosition().getCarPosition())
                    .mapToObj(n -> carKind)
                    .collect(joining(delimiter));
            System.out.println(result);
        });
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        String winners = cars.getCars().stream().map(
                car -> car.getName().getName()
        ).collect(joining(", "));

        System.out.println(winners + POST_WINNER_MESSAGE);
    }
}
