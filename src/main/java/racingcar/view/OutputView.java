package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String OUTPUT_CHARACTERS = "-";

    public static void printMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printOutResult(List<Cars> carsList) {
        carsList.forEach(cars -> System.out.println(getResult(cars) + "\n"));
    }

    public static void printOutWinner(Cars winners) {
        String winnerNames = winners.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String getResult(Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> {
                    int carPosition = car.getPosition();
                    String carName = car.getName();

                    return carName.concat(" : ").concat(replacePositionToOutputCharacters(carPosition));
                })
                .collect(Collectors.joining("\n"));
    }

    private static String replacePositionToOutputCharacters(int carPosition) {
        return IntStream.range(0, carPosition)
                .mapToObj(i -> OUTPUT_CHARACTERS)
                .collect(Collectors.joining());
    }
}
