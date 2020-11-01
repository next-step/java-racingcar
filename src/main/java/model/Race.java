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
    private List<Car> cars;
    private int tryCount;

    public void setCars (int carCount) {
        cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars () {
        return cars;
    }

    public void setTryCount (int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount () {
        return tryCount;
    }
}
