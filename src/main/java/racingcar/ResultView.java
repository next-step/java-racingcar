package racingcar;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PATH_SYMBOL = "-";
    private static final String WINNER_ANNOUNCMENT_MESSAGE = " 가 최종 우승했습니다.";


    public void printEveryLocation(List<Car> carList) {
        carList.forEach(c -> System.out.println(this.printNameAndLocation(c)));
        System.out.println();
    }

    private Integer getWinnerLocation(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getCurrentLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public String printNameAndLocation(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        printCarName(car, stringBuilder);
        printLocation(car, stringBuilder);
        return stringBuilder.toString();
    }

    private void printLocation(Car car, StringBuilder stringBuilder) {
        int count = 0;
        while (count < car.getCurrentLocation()) {
            stringBuilder.append(PATH_SYMBOL);
            count++;
        }
    }

    private void printCarName(Car car, StringBuilder stringBuilder) {
        stringBuilder.append(car.getCarName()).append(": ");
    }

    public void printWinners(List<Car> carList) {
        String winners = this.getWinners(carList);
        System.out.println(winners + WINNER_ANNOUNCMENT_MESSAGE);
    }
    public String getWinners(List<Car> carList) {
        Integer winnerLocation = getWinnerLocation(carList);

        return carList.stream()
                .filter(c -> c.getCurrentLocation() == winnerLocation)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
