package com.nextstep.racingcar.domain.car;

import java.util.List;

public interface CarFactory {
    List<Car> createByNumber(int number);
}
