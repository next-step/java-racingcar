package com.kkambi.racing.view;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.domain.Location;
import com.kkambi.racing.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LOCATION_UNIT = "-";

    public void printPhrase() {
        System.out.println();
        System.out.println("실행 결과");
    }
    
    public void printInformation(List<Car> cars) {
        for (Car car : cars) {
            printNameAndLocation(car);
        }
        System.out.println();
    }

    private void printNameAndLocation(Car car) {
        StringBuilder locationStringBuilder = new StringBuilder();
        Location location = car.getLocation();
        for (int i = 0; i < location.getValue(); i++) {
            locationStringBuilder.append(LOCATION_UNIT);
        }

        System.out.printf("%s : %s%n", car.getName().getValue(), locationStringBuilder.toString());
    }

    public void printWinners(Winners winners) {
        List<String> winnerNames = winners.getWinners().stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toList());
        System.out.printf("최종 우승은 %s !!!%n", String.join(", ", winnerNames));
    }
}
