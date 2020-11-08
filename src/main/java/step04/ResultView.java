package step04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResultView {
    private final String carKind;
    private ArrayList<List<Car>> raceSnapShop = new ArrayList<>();

    private final String delimiter = "";
    private final String joinDelimiter = ", ";
    private final String POST_WINNER_MESSAGE = "가 최종우승했습니다";
    private final String RESULT_START_MESSAGE = "실행 결과";

    private ResultView(String carKind) {
        this.carKind = carKind;
    }

    public static ResultView of(String carKind) {
        return new ResultView(carKind);
    }

    public void printRace() {
        System.out.println(RESULT_START_MESSAGE);

        for (List<Car> cars : raceSnapShop) {
            printCarsPosition(cars);
        }
    }

    public void setSnapShot(List<Car> cars) {
        raceSnapShop.add(cars);
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

    public void printWinner() {
        List<Car> lastSnapShot = raceSnapShop.get(raceSnapShop.size() - 1);
        int topPosition = lastSnapShot.stream()
                .sorted((a, b) -> b.getPosition() - a.getPosition())
                .limit(1)
                .collect(toList())
                .get(0)
                .getPosition();

        String winners = lastSnapShot.stream()
                .filter(car -> car.getPosition() == topPosition)
                .map(car -> car.name)
                .collect(joining(joinDelimiter));

        System.out.println(winners + POST_WINNER_MESSAGE);

    }
}
