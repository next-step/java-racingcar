package com.ssabae.nextstep.racingcar.step03.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class Cars {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVEMENT_MIN_VALUE = 4;

    private final List<Car> carList;
    private final Operator<MoveState> operator;
    private final Random random;

    private final Stream<Car> generate = Stream.generate(Car::new);

    public Cars(Random random, int count) {
        this.carList = new ArrayList<>();
        this.operator = new MoveOperator(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MOVEMENT_MIN_VALUE);
        this.random = random;
        this.generate.limit(count)
                .forEach(carList::add);
    }

    public void moving() {
        for (Car car : carList) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE + 1);
            MoveState operate = operator.operate(randomNumber);
            car.move(operate);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
