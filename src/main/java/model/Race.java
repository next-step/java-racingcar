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

public class Race {
    private Cars cars;

    public void createCars (int carCount) {
        List originalCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            originalCars.add(new Car());
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
}
