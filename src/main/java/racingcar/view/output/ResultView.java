package racingcar.view.output;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(List<Cars> records) {
        System.out.println("실행 결과");
        for (Cars record : records) {
            printCars(record);
        }
        printWinners(records);
    }

    private static void printCars(Cars cars) {
        for (Car car : cars.getValue()) {
            System.out.println(getCarPosition(car));
        }
        System.out.println();
    }

    private static String getCarPosition(Car car) {
        StringBuilder carInformation = new StringBuilder();
        carInformation.append(car.getName().getValue());
        carInformation.append(" : ");
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            carInformation.append("-");
        }
        return carInformation.toString();
    }

    public static void printWinners(List<Cars> records) {
        Cars finalRaceRecord = records.get(records.size() - 1);

        int winnerPosition = finalRaceRecord.getValue().stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("The winner is not exists."));

        List<String> winnerNames = finalRaceRecord.getValue().stream()
                .filter(car -> car.isEqualPositionValue(winnerPosition))
                .map(car -> car.getName().getValue())
                .collect(Collectors.toList());

        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }


}
