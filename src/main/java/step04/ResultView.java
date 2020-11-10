package step04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResultView {
    private final String carKind;

    private final String delimiter = "";
    private final String POST_WINNER_MESSAGE = "가 최종우승했습니다";
    private final String RESULT_START_MESSAGE = "실행 결과";

    private ResultView(String carKind) {
        this.carKind = carKind;
    }

    public static ResultView of(String carKind) {
        return new ResultView(carKind);
    }

    public void printRace(ArrayList<List<Car>> raceSnapShop) {
        System.out.println(RESULT_START_MESSAGE);

        for (List<Car> cars : raceSnapShop) {
            printCarsPosition(cars);
        }
    }

    private void printCarsPosition(List<Car> cars) {
        cars.forEach((car) -> {
            String result = car.name + " : " + IntStream.range(0, car.getPosition())
                    .mapToObj(n -> carKind)
                    .collect(joining(delimiter));
            System.out.println(result);
        });
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.println(winners + POST_WINNER_MESSAGE);
    }
}
