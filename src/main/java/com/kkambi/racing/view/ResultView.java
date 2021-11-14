package com.kkambi.racing.view;

import com.kkambi.racing.domain.Car;

import java.util.List;

public class ResultView {

    private static final String LOCATION_UNIT = "-";

    public void printPhrase() {
        System.out.println();
        System.out.println("실행 결과");
    }
    
    public void printLocations(List<Car> carList) {
        for (Car car : carList) {
            printLocation(car);
        }
        System.out.println();
    }

    private void printLocation(Car car) {
        StringBuilder locationStringBuilder = new StringBuilder();

        for (int i = 0; i < car.getLocation(); i++) {
            locationStringBuilder.append(LOCATION_UNIT);
        }

        System.out.println(locationStringBuilder.toString());
    }
}
