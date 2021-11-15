package com.kkambi.racing.view;

import com.kkambi.racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LOCATION_UNIT = "-";

    public void printPhrase() {
        System.out.println();
        System.out.println("실행 결과");
    }
    
    public void printInformation(List<Car> carList) {
        for (Car car : carList) {
            printNameAndLocation(car);
        }
        System.out.println();
    }

    private void printNameAndLocation(Car car) {
        StringBuilder locationStringBuilder = new StringBuilder();
        Car.Location location = car.getLocation();
        for (int i = 0; i < location.getValue(); i++) {
            locationStringBuilder.append(LOCATION_UNIT);
        }

        System.out.printf("%s : %s%n", car.getName().getValue(), locationStringBuilder.toString());
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(car -> car.getName().getValue()).collect(Collectors.toList());
        System.out.printf("최종 우승은 %s !!!%n", String.join(", ", winnerNames));
    }
}
