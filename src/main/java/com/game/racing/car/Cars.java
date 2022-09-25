package com.game.racing.car;

import com.game.racing.generator.IntegerGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    /**
     * 자동차를 움직일 수 있는 최소 기준값
     */
    public static final Integer MIN_VALUE_TO_MOVE_CAR = 4;

    private final List<Car> cars;

    private final IntegerGenerator integerGenerator;

    public Cars(Integer count, IntegerGenerator integerGenerator) {
        this.cars = new ArrayList<>();
        addNewCarsToListAsCount(count);
        this.integerGenerator = integerGenerator;
    }

    private void addNewCarsToListAsCount(Integer count) {
        for (int i = 0; i < count; i++) {
            this.cars.add(new Car());
        }
    }

    /**
     * 등록된 전체 자동차를 움직이는 메소드
     *
     * @return 움직인 자동차의 수를 Integer 형태로 리턴
     */
    public Integer moveCars() {
        int movedCarTotalCount = 0;
        for (Car car : cars) {
            movedCarTotalCount = moveCarAndGetCountIfMoves(movedCarTotalCount, car);
        }
        return movedCarTotalCount;
    }

    private int moveCarAndGetCountIfMoves(int movedCarTotalCount, Car car) {
        if (moveCarByGeneratedValue(car) > 0) {
            movedCarTotalCount++;
        }
        return movedCarTotalCount;
    }

    /**
     * 개별 자동차를 IntegerGenerator 를 통해 판별값에 따라 움직이고, 위치를 -(dash)로 출력하는 메소드
     *
     * @param car 개별 자동차
     * @return 개별 자동차가 움직이면 1, 움직이지 않았으면 0 을 리턴하는 메소드
     */
    public Integer moveCarByGeneratedValue(Car car) {
        int movedCarCount = 0;
        if (integerGenerator.generate() >= MIN_VALUE_TO_MOVE_CAR) {
            car.move();
            movedCarCount++;
        }
        car.printCurrentPosition();
        return movedCarCount;
    }
}
