package com.game.racing.car;

import com.game.racing.count.MovedCarTotalCount;
import com.game.racing.generator.NumberGenerator;
import com.game.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    /**
     * 자동차를 움직일 수 있는 최소 기준값
     */
    public static final Integer MIN_VALUE_TO_MOVE_CAR = 4;

    private final List<Car> cars;

    private final NumberGenerator numberGenerator;

    private final MovedCarTotalCount movedCarTotalCount;

    public Cars(Integer count, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        addNewCarsToListAsCount(count);
        this.numberGenerator = numberGenerator;
        this.movedCarTotalCount = new MovedCarTotalCount();
    }

    private void addNewCarsToListAsCount(Integer count) {
        for (int i = 0; i < count; i++) {
            this.cars.add(new Car());
        }
    }

    public Integer getMovedCarTotalCount() {
        return movedCarTotalCount.get();
    }

    public void moveCars() {
        for (Car car : cars) {
            moveCarByGeneratedValue(car);
        }
        ResultView.printNewLine();
    }

    /**
     * 개별 자동차를 IntegerGenerator 를 통해 판별값에 따라 움직이고, 위치를 -(dash)로 출력하는 메소드
     *
     * @param car 개별 자동차
     */
    public void moveCarByGeneratedValue(Car car) {
        ResultView.printCarCurrentPosition(car);
        if (numberGenerator.generate() >= MIN_VALUE_TO_MOVE_CAR) {
            car.move();
            movedCarTotalCount.addCount();
        }
    }
}
