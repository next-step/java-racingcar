/*
 * 클래스 이름
 * 레이스
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private Cars cars;

    public void createCars (String inputNames) {
        List originalCars = new ArrayList<>();
        String[] names = inputNames.split(",");

        for (String name : names) {
            originalCars.add(new Car(name));
        }

        cars = new Cars(originalCars);
    }

    public Cars go () {
        cars = new Cars(cars.stepForward());
        return cars;
    }

    public void printCars () {
        cars.printCars();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(cars, race.cars);
    }

    @Override
    public int hashCode () {
        return Objects.hash(cars);
    }
}
