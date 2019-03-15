package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.RaceResultDTO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String WINNER_MENT = "가 최종 우승했습니다.";

    public static String generateRaceResultString(Car car) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static String generateWinnersString(List<Car> cars) {
        List<String> winnerNames = getWinners(cars).stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        return String.join(", ", winnerNames) + WINNER_MENT;
    }

    public static void printRacingGameResult(List<RaceResultDTO> racingGameResult) {
        racingGameResult.forEach(raceResult -> {
            raceResult.getRunResults().forEach(System.out::println);
            System.out.println();
        });
    }

    private static List<Car> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> car.equalsPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .get()
            .getPosition();
    }
}
